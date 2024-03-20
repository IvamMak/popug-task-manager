package com.example.accounting.business.account.service.usecase;

import com.example.accounting.business.account.domain.Account;
import com.example.accounting.business.account.rest.ShowMyAccountStateUseCase;
import com.example.accounting.business.account.service.FindAccountService;
import com.example.accounting.business.user.domain.User;
import com.example.accounting.business.user.servcie.FindUserService;
import com.example.accounting.business.user.servcie.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShowMyAccountStateUseCaseImpl implements ShowMyAccountStateUseCase {
    private final FindUserService findUserService;
    private final FindAccountService findAccountService;

    @Override
    public Account show(String username) {
        User user = findUserService.find(username);
        return findAccountService.find(user.getPublicId());
    }
}
