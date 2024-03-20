package com.example.analytics.business.task.service;

import com.example.analytics.business.task.domain.Task;
import com.example.analytics.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.completed.TaskCompletedAccountingEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class TaskCompletedConsumer {
    private final SaveTaskService saveTaskService;

    @KafkaListener(topics = Topics.ACCOUNTING_TASK_COMPLETED_V1, groupId = "analytics-group")
    void listener(@Payload ConsumerRecord<String, TaskCompletedAccountingEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskCompletedAccountingEvent::getEventPayload)
                    .map(payload -> new Task(payload.getPublicId(), payload.getExecutorId(),
                            LocalDate.parse(payload.getDate()), payload.getPrice()))
                    .forEach(saveTaskService::save);
        } catch (EventException exception) {
            throw new EventException(consumerRecord.value().toString());
        }
    }
}
