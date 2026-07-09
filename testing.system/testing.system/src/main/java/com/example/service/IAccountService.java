package com.example.service;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.form.AccountCreateOrUpdateForm;

import java.util.List;

public interface IAccountService {
    List<AccountDTO> findAll();

    AccountDTO findById(Integer id);

    void deleteById(Integer id);

    void create(AccountCreateOrUpdateForm account);

    void update(AccountCreateOrUpdateForm account, Integer id);
}
