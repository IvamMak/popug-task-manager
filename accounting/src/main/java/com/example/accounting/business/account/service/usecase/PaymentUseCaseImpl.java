package com.example.accounting.business.account.service.usecase;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.rest.PaymentUseCase;
import com.example.accounting.business.account.service.FindAccountService;
import com.example.accounting.business.transaction.domain.TransactionType;
import com.example.accounting.business.transaction.service.ApplyTransactionService;
import com.example.accounting.business.user.servcie.FindUserService;
import com.example.accounting.exception.EventException;
import com.example.schemaregistry.Topics;
import com.example.schemaregistry.paymentcycle.state.PaymentCycleClosedEvent;
import com.example.schemaregistry.paymentcycle.state.PaymentCycleClosedPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {
    private final FindUserService findUserService;
    private final FindAccountService findAccountService;
    private final ApplyTransactionService applyTransactionService;
    private final KafkaTemplate<String, PaymentCycleClosedEvent> template;

    @Override
    public void pay() {
        findAccountService.findAllAccounts()
                .forEach(account -> {
                    sendMessage(account);
                    applyTransactionService.apply(account, TransactionType.PAYMENT);
                });
    }

    private void sendMessage(Account account) {
        try {
            PaymentCycleClosedPayload payload = PaymentCycleClosedPayload.newBuilder()
                    .setBalance(account.getBalance())
                    .setDate(LocalDate.now().toString())
                    .setUserPublicId(findUserService.find(account.getUserId()).getPublicId()).build();
            PaymentCycleClosedEvent event = PaymentCycleClosedEvent.newBuilder()
                    .setEventName(Topics.ACCOUNTING_PAYMENT_CYCLE_CLOSED_V1)
                    .setEventPayload(payload).build();
            template.send(Topics.ACCOUNTING_PAYMENT_CYCLE_CLOSED_V1, event);
        } catch (Exception exception) {
            throw new EventException(account.toString());
        }
    }
}
