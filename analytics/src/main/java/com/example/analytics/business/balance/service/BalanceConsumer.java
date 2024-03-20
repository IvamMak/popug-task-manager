package com.example.analytics.business.balance.service;

import com.example.analytics.business.balance.domain.Balance;
import com.example.analytics.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.paymentcycle.state.PaymentCycleClosedEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class BalanceConsumer {
    private final SaveBalanceService saveBalanceService;

    @KafkaListener(topics = Topics.ACCOUNTING_PAYMENT_CYCLE_CLOSED_V1, groupId = "analytics-group")
    void listener(@Payload ConsumerRecord<String, PaymentCycleClosedEvent> consumerRecord) {
        try {
            Stream.of(consumerRecord.value())
                    .map(PaymentCycleClosedEvent::getEventPayload)
                    .map(payload -> new Balance(LocalDate.parse(payload.getDate()), payload.getUserPublicId(),
                            payload.getBalance()))
                    .forEach(saveBalanceService::save);
        } catch (EventException exception) {
            throw new EventException(consumerRecord.value().toString());
        }
    }
}
