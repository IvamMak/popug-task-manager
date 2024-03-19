package com.example.accounting.business.transaction.rest;

import java.util.List;

public interface ShowTransactionStatisticUseCase {
    List<DailyStatisticResponse> show(String username);
}
