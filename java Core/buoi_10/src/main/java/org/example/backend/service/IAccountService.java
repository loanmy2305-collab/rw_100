package org.example.backend.service;

import org.example.entity.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAll();
    boolean insert(String username, String fullName, String email, int depId, int posId);
    boolean deleteAccount(int id);
    boolean update(int id, int updateDepId, int updatePosId);
    List<Account> findByIdAndName(String searchfullName, String searchusername);
    List<Account> findByName(String name);
    boolean checkExistUsernameAndIdNot(String username, Integer id);
    boolean checkExistEmailAndIdNot(String email, Integer id);
    boolean checkExistPositionID(int posId);
    boolean checkExistID(int id);
    boolean checkExistDepartmentID(int depId);
    boolean updateUsername(int id, String newUsername);

    boolean insert(Account acc);
}
