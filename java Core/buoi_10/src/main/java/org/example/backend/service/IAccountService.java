package org.example.backend.service;

import org.example.dto.context.AccountContext;
import org.example.dto.csv.AccountCsv;
import org.example.entity.Account;

import java.util.List;
import java.util.Map;

public interface IAccountService  extends  ImportFileCSV<AccountContext,Account, AccountCsv> {
    List<Account> findAll();
    boolean insert(String username, String fullName, String email, int depId, int posId);
    boolean deleteAccount(int id);
    boolean update(int id, int updateDepId, int updatePosId);
    List<Account> findByIdAndName(String searchfullName, String searchusername);
    List<Account> findByName(String name);
    Map<String, Account> mapAccountByUsername();

    boolean checkUsernameExist(String username,  Integer id);

    boolean checkEmailExist(String email);

    boolean checkIdExist(Integer id);

    boolean update(int id, String updateName);

    String importAccountFromCSV(String pathName);
}
