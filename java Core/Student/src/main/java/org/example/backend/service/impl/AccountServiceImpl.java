package org.example.backend.service.impl;

import org.example.backend.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountService accountService = new AccountServiceImpl();
    @Override
    public boolean login(String username, String password) {
        return accountService.login(username,password);
    }
}
