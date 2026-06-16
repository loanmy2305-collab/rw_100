package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.impl.AccountServiceImpl;

public class AccountController {
    private IAccountService accountService = new AccountServiceImpl();

    public boolean login(String username, String password) {
        return accountService.login(username, password);
    }
}