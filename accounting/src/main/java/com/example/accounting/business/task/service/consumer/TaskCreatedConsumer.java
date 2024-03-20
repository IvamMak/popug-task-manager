package com.example.accounting.business.task.service.consumer;

import com.example.accounting.business.dlq.service.SaveDeadMessageService;
import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.task.service.SaveTaskService;
import com.example.accounting.business.transaction.domain.TransactionType;
import com.example.accounting.business.transaction.service.ApplyTransactionService;
import com.example.accounting.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.created.TaskCreatedEvent;
import com.example.schemaregistry.task.created.TaskCreatedEventV2;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class TaskCreatedConsumer {
    private final SaveTaskService saveTaskService;
    private final ApplyTransactionService applyTransactionService;
    private final SaveDeadMessageService saveDeadMessageService;

    @KafkaListener(topics = Topics.TASK_STREAM, groupId = "accounting-group")
    void listen(@Payload ConsumerRecord<String, TaskCreatedEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskCreatedEvent::getEventPayload)
                    .map(payload -> new Task(payload.getPublicId(), payload.getExecutorId(),
                            payload.getCreatorId(), payload.getDescription()))
                    .peek(task -> applyTransactionService.apply(task, TransactionType.WITHDRAW))
                    .forEach(saveTaskService::save);
        } catch (Exception exception) {
            saveDeadMessageService.save(consumerRecord.topic(), consumerRecord);
        }
    }

    @KafkaListener(topics = Topics.TASK_STREAM_V2, groupId = "accounting-group")
    void listenSecondVersion(@Payload ConsumerRecord<String, TaskCreatedEventV2> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskCreatedEventV2::getEventPayload)
                    .map(payload -> new Task(payload.getPublicId(), payload.getExecutorId(),
                            payload.getCreatorId(), payload.getDescription()))
                    .peek(task -> applyTransactionService.apply(task, TransactionType.WITHDRAW))
                    .forEach(saveTaskService::save);
        } catch (Exception exception) {
            saveDeadMessageService.save(consumerRecord.topic(), consumerRecord);
        }
    }
}
