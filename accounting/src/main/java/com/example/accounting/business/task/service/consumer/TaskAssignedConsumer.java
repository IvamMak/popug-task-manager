package com.example.accounting.business.task.service.consumer;

import com.example.accounting.business.dlq.service.SaveDeadMessageService;
import com.example.accounting.business.task.service.FindTaskService;
import com.example.accounting.business.task.service.SaveTaskService;
import com.example.accounting.business.transaction.domain.TransactionType;
import com.example.accounting.business.transaction.service.ApplyTransactionService;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.assigned.TaskAssignedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class TaskAssignedConsumer {
    private final SaveTaskService saveTaskService;
    private final FindTaskService findTaskService;
    private final ApplyTransactionService applyTransactionService;
    private SaveDeadMessageService saveDeadMessageService;

    @KafkaListener(topics = Topics.TASK_SHUFFLE, groupId = "accounting-group")
    void listener(@Payload ConsumerRecord<String, TaskAssignedEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskAssignedEvent::getEventPayload)
                    .map(payload -> findTaskService.find(payload.getPublicId()))
                    .peek(task -> applyTransactionService.apply(task, TransactionType.WITHDRAW))
                    .forEach(saveTaskService::save);
        } catch (Exception exception) {
            saveDeadMessageService.save(consumerRecord.topic(), consumerRecord);
        }
    }
}
