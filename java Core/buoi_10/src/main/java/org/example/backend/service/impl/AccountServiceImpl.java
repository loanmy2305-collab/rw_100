package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.entity.Account;

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

    @Override
    public boolean checkExistUsernameAndIdNot(String username, Integer id) {
        boolean check = accountRepository.checkExistUsernameAndIdNot(username, id);
        return check;
    }

    @Override
    public boolean checkExistEmailAndIdNot(String email, Integer id) {
        boolean check = accountRepository.checkExistEmailAndIdNot(email, id);
        return check;
    }

    @Override
    public boolean checkExistPositionID(int posId) {
        boolean check = accountRepository.checkExistPositionID(posId);
        return check;
    }

    @Override
    public boolean checkExistID(int id) {
        boolean check = accountRepository.checkExistID(id);
        return check;
    }

    @Override
    public boolean checkExistDepartmentID(int depId) {
        boolean check = accountRepository.checkExistDepartmentID(depId);
        return check;
    }

    @Override
    public boolean updateUsername(int id, String newUsername) {
        boolean check = accountRepository.updateUsername(id, newUsername);
        return check;
    }

    @Override
    public boolean insert(Account acc) {
        boolean check = accountRepository.insert(acc);
        return check;
    }


}
