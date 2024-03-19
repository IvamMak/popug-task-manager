package com.example.accounting.business.account.rest;

import com.example.accounting.business.account.domain.Account;

public interface ShowMyAccountStateUseCase {
    Account show(String username);
}
