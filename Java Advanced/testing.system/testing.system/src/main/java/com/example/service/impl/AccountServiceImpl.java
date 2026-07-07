package com.example.service.impl;

import com.example.entity.Account;
import com.example.entity.Position;
import com.example.repository.IAccountRepository;
import com.example.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public List<Account> findAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Account findById(Integer id) {
        Account account = accountRepository.findById(id).orElse(null);
        // orElse(null) :
        return account;
    }

    @Override
    public void deleteById(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void create(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void update(Account account, Integer id) {
        // tìm dep câần update theo id
        Account accountUpdate = accountRepository.findById(id).orElse(null);
        if (Objects.isNull(accountUpdate)){
            throw new RuntimeException("ID not found!");
        }else {
            //lưu lại thông tin update
            accountUpdate.setEmail(account.getEmail());
            accountUpdate.setUsername(account.getUsername());
            accountUpdate.setFullName(account.getFullName());

            accountRepository.save(accountUpdate);
        }
    }
}
