package com.example.accounting.business.transaction.service.usecase;

import com.example.accounting.business.transaction.domain.Transaction;
import com.example.accounting.business.transaction.rest.DailyStatisticResponse;
import com.example.accounting.business.transaction.rest.ShowTransactionStatisticUseCase;
import com.example.accounting.business.transaction.service.FindTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowTransactionStatisticUseCaseImpl implements ShowTransactionStatisticUseCase {
    private final FindTransactionService findTransactionService;

    @Override
    public List<DailyStatisticResponse> show(String username) {
        return findTransactionService.findAllDebitAndCreditTransactions().stream()
                .collect(Collectors.groupingBy(transaction -> transaction.getTimeStamp().toLocalDate()))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
                        .map(transaction -> transaction.getAmount() * -1).reduce(Double::sum).orElse(0.0)))
                .entrySet().stream()
                .map(entry -> new DailyStatisticResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

    }
}
