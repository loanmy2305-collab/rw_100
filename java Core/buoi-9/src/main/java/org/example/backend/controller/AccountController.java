package org.example.backend.controller;

import org.example.backend.service.IAccountService;
import org.example.backend.service.IDepartmentService;
import org.example.backend.service.impl.AccountServiceImpl;
import org.example.backend.service.impl.DepartmentServiceImpl;
import org.example.entity.Account;
import org.example.entity.Department;

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

    public List<Account> findByIdAndName(String searchfullName, String searchusername) {
        // lấy ds từu service
        List<Account> accounts = accountService.findByIdAndName(searchfullName, searchusername);
        return accounts;
    }

    public List<Account> findByName(String name) {
        // lấy ds từu service
        List<Account> accounts = accountService.findByName(name);
        return accounts;
    }


}