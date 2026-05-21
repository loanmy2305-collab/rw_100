package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.impl.AccountServiceImpl;
import org.example.entity.Account;

import java.util.List;
import java.util.Map;
import java.util.Map;

public class AccountController {
    private IAccountService accountService = new AccountServiceImpl();

    public List<Account> findAll() {
        // lấy ds từu service
        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    public boolean insert(String username, String fullName, String email, int depId, int posId) {
        boolean check = accountService.insert(username, fullName, email, depId, posId);
        return check;
    }

    public boolean deleteAccount(int id) {
        boolean check = accountService.deleteAccount(id);
        return check;
    }

    public boolean update(int id, int updateDepId, int updatePosId) {
        boolean check = accountService.update(id,updateDepId, updatePosId);
        return check;
    }



    public List<Account> findByName(String name) {
        // lấy ds từu service
        List<Account> accounts = accountService.findByName(name);
        return accounts;
    }


    public Map<String, Account> mapAccountByUsername() {
        return accountService.mapAccountByUsername();
    }

    public boolean checkUsernameExist(String username, Integer id) {
        return accountService.checkUsernameExist(username, id);
    }

    public boolean checkEmailExist(String email) {
        return accountService.checkEmailExist(email);
    }

    public boolean checkIdExist(Integer id) {
        return accountService.checkIdExist(id);
    }

    public boolean update(int id, String updateName) {
        return accountService.update(id, updateName);
    }
}