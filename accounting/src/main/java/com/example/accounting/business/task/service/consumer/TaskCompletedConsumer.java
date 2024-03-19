package com.example.accounting.business.task.service.consumer;

import com.example.accounting.business.dlq.service.SaveDeadMessageService;
import com.example.accounting.business.task.domain.Task;
import com.example.accounting.business.task.service.FindTaskService;
import com.example.accounting.business.task.service.SaveTaskService;
import com.example.accounting.business.transaction.domain.TransactionType;
import com.example.accounting.business.transaction.service.ApplyTransactionService;
import com.example.accounting.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.completed.TaskCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class TaskCompletedConsumer {
    private final SaveTaskService saveTaskService;
    private final FindTaskService findTaskService;
    private final ApplyTransactionService applyTransactionService;
    private SaveDeadMessageService saveDeadMessageService;

    @KafkaListener(topics = Topics.TASK_COMPLETED, groupId = "accounting-group")
    void listener(@Payload ConsumerRecord<String, TaskCompletedEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskCompletedEvent::getEventPayload)
                    .map(payload -> findTaskService.find(payload.getPublicId()))
                    .peek(Task::completeTask)
                    .peek(task -> applyTransactionService.apply(task, TransactionType.DEPOSIT))
                    .forEach(saveTaskService::save);
        } catch (EventException exception) {
            saveDeadMessageService.save(consumerRecord.topic(), consumerRecord);
        }
    }
}
