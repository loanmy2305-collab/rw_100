package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.impl.AccountServiceImpl;
import org.example.entity.Account;

import java.util.List;

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


    public boolean checkExistUsernameAndIdNot(String username, Integer id) {
        boolean check = accountService.checkExistUsernameAndIdNot(username,id);
        return check;
    }

    public boolean checkExistEmailAndIdNot(String email, Integer id) {
        boolean check = accountService.checkExistEmailAndIdNot(email,id);
        return check;
    }

    public boolean checkExistPositionID(int posId) {
        boolean check = accountService.checkExistPositionID(posId);
        return check;
    }

    public boolean checkExistID(int id) {
        boolean check = accountService.checkExistID(id);
        return check;
    }

    public boolean checkExistDepartmentID(int depId) {
        boolean check = accountService.checkExistDepartmentID(depId);
        return check;
    }

    public boolean updateUsername(int id, String newUsername) {
        boolean check = accountService.updateUsername(id, newUsername);
        return check;
    }

    public boolean insert(Account acc) {
        boolean check = accountService.insert(acc);
        return check;
    }
}