package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
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

    @Override
    public String importAccountFromCSV(String pathName) {
        // dọc dữ liệu từ file và dưa dữ lệu cho repository để lưu vào DB
        if (!pathName.endsWith(".csv")) {
            return "dịnh dạng file không đuúng";
        }
//        // FileReader:là 1 đói tượng dùngdể đọc file ,đọc từng kí tự
//        // BuferrdReader: hỗ trợ đọc theo từng dòng

        List<Account> accounts = new ArrayList<>();
        boolean firstLine = true;
        boolean checkCreate = false;
        String header = "";
        int accountID = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            header = br.readLine();// bo di dong header
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String username = fields[0];
                String fullName = fields[1];
                String email = fields[2];
                String departmentId = fields[3];
                String positionId = fields[4];


                Account account = new Account(username, fullName, email, departmentId, positionId);
                accounts.add(account);
            }
            if (!accounts.isEmpty()) {
                checkCreate = accountRepository.createListAccount(accounts);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Import thành công";
    }


}
