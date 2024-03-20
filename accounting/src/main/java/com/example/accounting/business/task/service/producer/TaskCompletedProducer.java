package com.example.accounting.business.task.service.producer;

import com.example.accounting.business.task.domain.Task;
import com.example.accounting.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.task.completed.TaskCompletedAccountingEvent;
import com.example.schemaregistry.task.completed.TaskCompletedAccountingPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TaskCompletedProducer {
    private final KafkaTemplate<String, TaskCompletedAccountingEvent> template;

    public void produce(Task task) {
        try {
            TaskCompletedAccountingPayload payload = TaskCompletedAccountingPayload.newBuilder()
                    .setDate(LocalDate.now().toString())
                    .setExecutorId(task.getExecutorId())
                    .setPrice(task.getCompletePrice())
                    .setPublicId(task.getPublicId()).build();
            TaskCompletedAccountingEvent event = TaskCompletedAccountingEvent.newBuilder()
                    .setEventName(Topics.ACCOUNTING_TASK_COMPLETED_V1)
                    .setEventPayload(payload).build();
            template.send(Topics.ACCOUNTING_TASK_COMPLETED_V1, event);
        } catch (Exception exception) {
            throw new EventException(task.getCreatorId());
        }

    }
}
