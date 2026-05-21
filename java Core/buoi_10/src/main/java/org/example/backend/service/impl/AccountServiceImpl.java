package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.entity.Account;

import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Account> mapAccountByUsername() {
        return accountRepository.mapAccountByUsername();
    }

    @Override
    public boolean checkUsernameExist(String username, Integer id) {
        return accountRepository.checkUsernameExist(username, id);
    }

    @Override
    public boolean checkEmailExist(String email) {
        return accountRepository.checkEmailExist(email);
    }

    @Override
    public boolean checkIdExist(Integer id) {
        return accountRepository.checkIdExist(id);

    }

    @Override
    public boolean update(int id, String updateName) {
        return accountRepository.update(id, updateName);
    }




}
