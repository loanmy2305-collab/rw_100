package org.example.backend.service.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.IPositionRepository;
import org.example.backend.repository.impl.AccountRepositoryImpl;
import org.example.backend.repository.impl.DepartmentRepositoryImpl;
import org.example.backend.repository.impl.PositionRepositoryImpl;
import org.example.backend.service.IAccountService;
import org.example.dto.ImportError;
import org.example.dto.context.AccountContext;
import org.example.dto.context.DepartmentContext;
import org.example.dto.csv.AccountCsv;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;
import org.example.utils.ScannerUtils;

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
        return accountRepository.mapByUsername();
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



//    @Override
//    public String importAccountFromCSV(String pathName) {
//        // check file c tồn tại không
//        File file = new File(pathName);
//        if (!file.exists()) {
//            return "File không tồn tại";
//        }
//        if (!pathName.endsWith(".csv")) {
//            return "File ko đúng định dạng!";
//        }
//        List<Account> accounts = new ArrayList<>();
//        boolean firstLine = true;
//        boolean checkImport = false;
//        String header = "";
//        int accountID = 0;
//        List<ImportError<AccountCsv>> importErrors = new ArrayList<>();
//        Map<String, Account> mapAccountByUsername = accountRepository.mapByUsername();
//        Map<String, Account> mapAccountByEmail = accountRepository.mapAccountByEmail();
//        List<Department> departments = departmentRepository.findAll();// kiem tra xem departmentID import vao co ton tai hay ko
//        List<Position> positions = positionRepository.findAll();
//        try (BufferedReader br = new BufferedReader(new FileReader(pathName))) {
//            header = br.readLine();// bo di dong header
//            String line;
//            while ((line = br.readLine()) != null) {
//                this.validation(line, mapAccountByUsername, mapAccountByEmail, departments, positions, accounts, importErrors);
//            }
//            if (!accounts.isEmpty()) {
//                checkImport = accountRepository.createListAccount(accounts);
//            }
//
//            // xuat file
//            String pathError = "C:\\Users\\FPT\\Desktop\\rw100\\csv\\account_error.csv";// nơi mà sẽ lưu file lỗi
//            this.exportCSV(header, pathError, importErrors);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        String message = "";
//        if (importErrors.isEmpty()) {
//            message = "Import thành công";
//        }
//        if (accounts.isEmpty()) {
//            message = "Import ko thành công, đã xuất file lỗi csv\\account_error.csv";
//        }
//        if (!importErrors.isEmpty() && !accounts.isEmpty()) {
//            message = "Import thành công " + accounts.size() + " nhân viên, " +
//                    "đã xuất lỗi ra file csv\\account_error.csv";
//        }
//        return message;
//    }

    public void validation(String line, Map<String, Account> mapByUsername, Map<String, Account> mapByEmail,
                           List<Department> departments, List<Position> positions, List<Account> accountSuccess,
                           List<ImportError<AccountCsv>> importErrors) {
        String[] fields = line.split(",", -1);
        List<String> errors = new ArrayList<>();
        String username = fields[0];
        String email = fields[1];
        String fullName = fields[2];
        String departmentId = fields[3];//"1"  "2"
        String positionId = fields[4];
        AccountCsv accountCsv = new AccountCsv(email, fullName, username, departmentId, positionId);

        //validation
        if (Objects.isNull(username) || username.trim().isEmpty()) {
            errors.add("Username không dc để trống");
        } else if (mapByUsername.get(username) != null) {// check xem username da ton tai chua
            errors.add("Username đã tồn tại");
        }

        if (Objects.isNull(email) || email.trim().isEmpty()) {
            errors.add("Email không dc để trống");
        } else if (!email.matches(ScannerUtils.EMAIL_REGEX)) {// kiểm tra  định dạng email "a@b"
            errors.add("Email không đúng định dạng");
        } else if (mapByEmail.get(email) != null) {// check xem username da ton tai chua
            errors.add("Email đã tồn tại");
        }

        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
            errors.add("FullName không dc để trống");
        }

        // kiêm tra xem day phai la so hay ko
        Department department = null;
        if (!departmentId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("DepartmentId phải là số");
        } else {
            // kiểm tra xem departmentId có tồn tại ko
            boolean checkDepartment = false;
            for (Department de : departments) {
                if (de.getId() == Integer.parseInt(departmentId)) {
                    department = de;
                    checkDepartment = true;
                    break;
                }
            }
            if (!checkDepartment) {
                errors.add("DepartmentId này không tồn tại");
            }
        }

        // kiêm tra xem day phai la so hay ko
        Position position = null;
        if (!positionId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("PositionId phải là số");
        } else {
            // kiểm tra xem positionId có tồn tại ko
            boolean checkPosition = false;
            for (Position po : positions) {
                if (po.getId() == Integer.parseInt(positionId)) {
                    position = po;
                    checkPosition = true;
                    break;
                }
            }
            if (!checkPosition) {
                errors.add("PositionId này không tồn tại");
            }
        }
        if (errors.isEmpty()) {// nếu ko có 1 loi nao
            Account account = new Account(username, fullName, email, department, position);
            accountSuccess.add(account);

            mapByEmail.put(email, account);
            mapByUsername.put(username, account);
        } else {
            // them line lỗi + ds lỗi liên quan vao list de ti nữa xuat file loi
            ImportError<AccountCsv> error = new ImportError(accountCsv, errors);
            importErrors.add(error);
        }
    }

    public void exportCSV(String header, String pathError, List<ImportError<AccountCsv>> importErrors) {
        if (!importErrors.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write(header + ",error_message");
                bw.newLine();
                for (ImportError error : importErrors) {
                    String ln = error.getCsv().toString() + "," + String.join("|", error.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void validation(String line, AccountContext context, List<Account> etities, List<ImportError<AccountCsv>> importErrors) {

        String[] fields = line.split(",", -1);
        List<String> errors = new ArrayList<>();
        String username = fields[0];
        String email = fields[1];
        String fullName = fields[2];
        String departmentId = fields[3];//"1"  "2"
        String positionId = fields[4];
        AccountCsv accountCsv = new AccountCsv(email, fullName, username, departmentId, positionId);

        //validation
        if (Objects.isNull(username) || username.trim().isEmpty()) {
            errors.add("Username không dc để trống");
        } else if (mapAccountByUsername().get(username) != null) {// check xem username da ton tai chua
            errors.add("Username đã tồn tại");
        }

        if (Objects.isNull(email) || email.trim().isEmpty()) {
            errors.add("Email không dc để trống");
        } else if (!email.matches(ScannerUtils.EMAIL_REGEX)) {// kiểm tra  định dạng email "a@b"
            errors.add("Email không đúng định dạng");
        } else if (mapAccountByUsername().get(email) != null) {// check xem username da ton tai chua
            errors.add("Email đã tồn tại");
        }

        if (Objects.isNull(fullName) || fullName.trim().isEmpty()) {
            errors.add("FullName không dc để trống");
        }

        // kiêm tra xem day phai la so hay ko
        Department department = null;
        if (!departmentId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("DepartmentId phải là số");
        } else {
            // kiểm tra xem departmentId có tồn tại ko
            boolean checkDepartment = false;
            for (Department de : context.getDepartments() ) {
                 if (de.getId() == Integer.parseInt(departmentId)) {
                    department = de;
                    checkDepartment = true;
                    break;
                }
            }
            if (!checkDepartment) {
                errors.add("DepartmentId này không tồn tại");
            }
        }

        // kiêm tra xem day phai la so hay ko
        Position position = null;
        if (!positionId.matches(ScannerUtils.NUMBER_REGEX)) {
            errors.add("PositionId phải là số");
        } else {
            // kiểm tra xem positionId có tồn tại ko
            boolean checkPosition = false;
            for (Position po : context.getPositions()) {
                if (po.getId() == Integer.parseInt(positionId)) {
                    position = po;
                    checkPosition = true;
                    break;
                }
            }
            if (!checkPosition) {
                errors.add("PositionId này không tồn tại");
            }
        }
        if (errors.isEmpty()) {// nếu ko có 1 loi nao
            Account account = new Account(username, fullName, email, department, position);
            etities.add(account);

            mapAccountByUsername().put(email, account);
            mapAccountByUsername().put(username, account);
        } else {
            // them line lỗi + ds lỗi liên quan vao list de ti nữa xuat file loi
            ImportError<AccountCsv> error = new ImportError(accountCsv, errors);
            importErrors.add(error);
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
        accountRepository.createListAccount(entities);

    }

    @Override
    public void exportFileError(List<ImportError<AccountCsv>> importErrors, String pathError) {


        if (!importErrors.isEmpty()) {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathError));
                bw.write(",error_message");
                bw.newLine();
                for (ImportError error : importErrors) {
                    String ln = error.getCsv().toString() + "," + String.join("|", error.getMessage());
                    bw.write(ln);
                    bw.newLine();
                }
                bw.flush();
            } catch (Exception e) {
            }
        }
    }

    @Override
    public String importAccountFromCSV(String pathName) {
       String pathError = "C:\\Users\\LOAN\\OneDrive\\Tài liệu\\rw_100\\csv\\account_error.csv";// nơi mà sẽ lưu file lỗi

        //lap ra map -> đưa map vào accountcontex
        Map<String, Account> mapAccountByUsername = accountRepository.mapAccountByUsername();
        Map<String, Account> mapAccountByEmail = accountRepository.mapAccountByEmail();
        List<Department> departments = departmentRepository.findAll();
        List<Position> positions = positionRepository.findAll();
        AccountContext context = new AccountContext(mapAccountByUsername,mapAccountByEmail,departments,positions);
        String message = this.importFileCSV(pathName, context, pathError);
        return message;
    }

}







