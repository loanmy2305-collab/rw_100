package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.backend.service.IDepartmentService;
import org.example.entity.Account;
import org.example.entity.Department;

import java.util.List;

public class AccountServiceImpl implements IAccountService {
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public boolean insert(String username, String fullName, String email, int depId, int posId) {
        boolean check = accountRepository.insert(username, fullName, email, depId, posId);
        return check;
    }

    @Override
    public boolean deleteAccount(int id) {
        boolean check = accountRepository.deleteAccount(id);
        return check;
    }

    @Override
    public boolean update(int id, int updateDepId, int updatePosId) {
        boolean check = accountRepository.deleteAccount(id);
        return check;
    }

    @Override
    public List<Account> findByIdAndName(String searchfullName, String searchusername) {
        List<Account> accounts = accountRepository.findByIdAndName(searchfullName, searchusername);
        return accounts;
    }

    @Override
    public List<Account> findByName(String name) {
        List<Account> accounts = accountRepository.findByName(name);
        return accounts;
    }


}
