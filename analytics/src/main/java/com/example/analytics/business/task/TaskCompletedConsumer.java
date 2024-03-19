package com.example.analytics.business.task;

import com.example.analytics.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.completed.TaskCompletedEvent;
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

    @KafkaListener(topics = Topics.TASK_COMPLETED, groupId = "accounting-group")
    void listener(@Payload ConsumerRecord<String, TaskCompletedEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(TaskCompletedEvent::getEventPayload)
                    .map(payload -> new Task(payload.getPublicId(), LocalDate.now(), payload.ge))
        } catch (EventException exception) {
            throw new EventException(consumerRecord.value().toString());
        }
    }
}
