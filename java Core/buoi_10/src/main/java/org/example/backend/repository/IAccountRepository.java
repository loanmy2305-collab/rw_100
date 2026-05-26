package org.example.backend.repository;

import org.example.entity.Account;
import org.example.entity.Department;

import java.util.List;
import java.util.Map;

public interface IAccountRepository {
    List<Account> findAll();
    boolean insert(String username, String fullName, String email, int depId, int posId);
    boolean deleteAccount(int id);
    boolean update(int id, int updateDepId, int updatePosId);
    List<Account> findByIdAndName(String searchfullName, String searchusername);
    List<Account> findByName(String name);
    Map<String, Account> mapAccountByUsername();

    boolean checkUsernameExist(String username, Integer id);

    boolean checkEmailExist(String email);

    boolean checkIdExist(Integer id);

    boolean update(int id, String updateName);
    boolean createListAccount(List<Account> accounts);
    Map<String, Account> mapByEmail();


}

