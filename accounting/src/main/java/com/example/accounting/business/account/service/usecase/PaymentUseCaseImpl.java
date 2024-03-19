package com.example.accounting.business.account.service.usecase;

import com.example.accounting.business.account.rest.PaymentUseCase;
import com.example.accounting.business.account.service.FindAccountService;
import com.example.accounting.business.transaction.domain.TransactionType;
import com.example.accounting.business.transaction.service.ApplyTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentUseCaseImpl implements PaymentUseCase {
    private final FindAccountService findAccountService;
    private final ApplyTransactionService applyTransactionService;
    @Override
    public void pay() {
        findAccountService.findAllAccountsWithPositiveBalance()
                .forEach(account -> applyTransactionService.apply(account, TransactionType.PAYMENT));
    }
}
