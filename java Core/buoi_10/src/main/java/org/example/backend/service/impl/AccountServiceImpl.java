package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.dto.ImportError;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AccountServiceImpl implements IAccountService {
    private IAccountRepository accountRepository = new AccountRepositoryImpl();
    private IDepartmentRepository departmentRepository = new DepartmentRepositoryImpl();
    private IPositionRepository positionRepository = new PositionRepositoryImpl();

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
        // check file c tồn tại không
        File file = new File(pathName);
        if (!file.exists()) {
            return "file không tồn tai";
        }

        // dọc dữ liệu từ file và dưa dữ lệu cho repository để lưu vào DB
        if (!pathName.endsWith(".csv")) {
            return "dịnh dạng file không đuúng";
        }
        //C:\Users\LOAN\Documents\rw_100\csv\input_account.csv
//        // FileReader:là 1 đói tượng dùngdể đọc file ,đọc từng kí tự
//        // BuferrdReader: hỗ trợ đọc theo từng dòng

        List<ImportError> importErrors = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        boolean firstLine = true;
        String header = "";
        int accountID = 0;
        Map<String, Account> mapByEmail = accountRepository.mapByEmail();
        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
            header = br.readLine();// bo di dong header
            String line;
            while ((line = br.readLine()) != null) {
                this.validation(line, mapByEmail, accounts, importErrors);
            }
            accountRepository.createListAccount(accounts);
            // xuất ra file lỗi
            String pathError = "\\Users\\LOAN\\Documents\\rw_100\\csv\\output_error_account.csv";
            this.exportFileCSV(importErrors, pathError);

        } catch (Exception e) {
//            throw new RuntimeException(e);
        }


        String message = "";
        if (importErrors.isEmpty()) {
            message = "Import thành công";
        }
        if (accounts.isEmpty()) {
            message = "Import k thành công , đã xuất file lỗi csv\\ouput_error_account.csv";
        }
        if (!importErrors.isEmpty() && !accounts.isEmpty()) {
            message = "Import thành công" + accounts.size() + "chức vụ " +
                    "đã xuất file lỗi csv\\ouput_error_account.csv";
        }
        return message;
    }

    public void exportFileCSV(List<ImportError> importErrors, String pathError) {

        if (!importErrors.isEmpty()) {
            try {
                // String pathError = "\\Users\\LOAN\\Documents\\rw_100\\csv\\output_error_account.csv";
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                // ghi header
                bw.write("line,error");
                bw.newLine();
                for (ImportError errors : importErrors) {
                    String ln = errors.getLine() + "," + String.join("|", errors.getMesage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
//                      e.printStackTrace();
            }
        }
    }

    public void validation(String line, Map<String, Account> mapByName, List<Account> accounts, List<ImportError> importErrors) {

        Map<String, Account> mapByEmail = accountRepository.mapByEmail();
        List<Department> departments = departmentRepository.findAll();// kiem tra xem departmentID import vao co ton tai hay ko
        List<Position> positions = positionRepository.findAll();
        String[] fields = line.split(",", -1);
        List<String> errors = new ArrayList<>();
        String username = fields[0];
        String fullName = fields[1];
        String email = fields[2];
        String departmentId = fields[3];
        String positionId = fields[4];

        Department department = null;
        for (Department de : departments) {
            if (de.getId() == Integer.parseInt(departmentId)) {
                department = de;
                break;
            }
        }
        Position position = null;
        for (Position po : positions) {
            if (po.getId() == Integer.parseInt(positionId)) {
                position = po;
                break;
            }
        }

        // validation

        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
            // tên  không được để troosng
            errors.add(" tên  không được để trống");
        }
        if (Objects.isNull(email) || email.trim().isEmpty()) {
            errors.add("email rỗng");
        } else if (mapByEmail.get(email) != null) {
            errors.add("Email tồn tại");
        }
        if (errors.isEmpty()) {
            Account acc = new Account(username, fullName, email, department, position);
            accounts.add(acc);
            mapByEmail.put(email, acc);
        } else {
            ImportError importError = new ImportError(line, errors);
            importErrors.add(importError);
        }
    }
    }







