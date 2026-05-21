package org.example.frontend;

import org.example.backend.controller.AccountController;
import org.example.backend.controller.DepartmentController;
import org.example.backend.controller.PositionController;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;
import org.example.utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private AccountController accountController = new AccountController();
    private DepartmentController departmentController = new DepartmentController();
    private PositionController positionController = new PositionController();
    private static Scanner scanner = new Scanner(System.in);

    public  void run() throws ClassNotFoundException {
        while (true) {
            System.out.println("=== mời bạn chọn chức năng ===");
            System.out.println("1.xem ds tài khoan");
            System.out.println("2.them mới tài khoan");
            System.out.println("3.update tài khoan");
            System.out.println("4.xóa tài khoan");
            System.out.println("5.tìm kiếm chức vụ theo tên");
            System.out.println("6.tìm kiếm chức vụ theo tên và username");
            System.out.println("7.thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Account> accounts = accountController.findAll();
                    this.showAccount(accounts);
                    break;
                case "2":
                    this.insertAccount();
                    break;
                case "3":
                    this.deleteAccount();
                    break;
                case "4":
                    this.updateAccount();
                    break;
                case "5":
                    this.findByIdAndName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }

    public  void showAccount(List<Account> accounts) {
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", "ID", "FullName", "Email", "Username", "Tên", "Tên chức vụ");
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
        for (Account account : accounts) {
            System.out.printf("|%5s|%20s|%20s|%20s|%20s|%20s|\n", account.getId(), account.getFullName(), account.getEmail(), account.getUsername(), account.getDepartment().getName(), account.getPosition().getName().name());
        }
        if (accounts.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+--------------------+--------------------+--------------------+--------------------+");
    }


    public void insertAccount() {
        String fullName;
        String username;
        String email;

        System.out.println("Nhập email: ");
        while (true) {
            email = ScannerUtils.inputEmail();
            // check trung
            if (accountController.checkEmailExist(email)) {
                System.out.println("email đã tồn tại. Nhập lại:");
                continue;
            }
            break;
        }

        // validation username
        System.out.println("Nhập username: ");
        while (true) {
            username = ScannerUtils.inputString();
            // check trung
            if (accountController.checkUsernameExist(username, null)) {
                System.out.println("Username đã tồn tại. Nhập lại:");
                continue;
            }
            break;
        }

        // validation fullName
        System.out.println("Nhập fullName: ");
        fullName = ScannerUtils.inputString();

        System.out.println("Chọn ID department: ");
        List<Department> departments = departmentController.findAll();
        Integer depID;
        while (true) {
            for (Department department : departments) {
                System.out.println("ID: " + department.getId() + ", DepartmentName: " + department.getName());
            }
            depID = ScannerUtils.inputIntGreaterThenZero();
            // check departmentID có tồn tại ko
            boolean checkExists = departmentController.checkExistID(depID);//Integer.valueOf("abc")
            if (!checkExists) {
                System.out.println("Không ton tại deparmentID này:");

            } else {
                break;
            }
        }

        System.out.println("Chọn ID position: ");
        List<Position> positions = positionController.findAll();
        Integer poID;
        while (true) {
            for (Position position : positions) {
                System.out.println("ID: " + position.getId() + ", PositionName: " + position.getName());
            }

            poID = ScannerUtils.inputIntGreaterThenZero();
            // check positionID có tồn tại ko
            boolean checkExists = checkExistPosition(positions, String.valueOf(poID));//Integer.valueOf("abc")
            if (!checkExists) {
                System.out.println("Không ton tại positionID này:");
            } else {
                break;
            }
        }
        boolean check = accountController.insert(email, username, fullName, depID, poID);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm mới thất bại");
        }
    }


    public void deleteAccount() {
        int id;
        System.out.println("Nhập ID cần xóa: ");
        while (true) {
            id = ScannerUtils.inputIntGreaterThenZero();
            // kiem tra xem id nay co ton tai ko
            if (!accountController.checkIdExist(id)) {
                System.out.println(" ID này không ton tai. Nhap lai: ");
            } else {
                break;
            }
        }

        boolean check = accountController.deleteAccount(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }


    public void updateAccount() {
        Integer id;
        String username;
        System.out.println("Nhập ID cần sửa: ");
        while (true) {
            id = ScannerUtils.inputIntGreaterThenZero();
            // kiem tra xem id nay co ton tai ko
            if (!accountController.checkIdExist(id)) {
                System.out.println(" ID này không ton tai. Nhap lai: ");
            } else {
                break;
            }
        }

        System.out.println("Nhập username: ");
        while (true) {
            username = ScannerUtils.inputString();
            // check trung
            if (accountController.checkUsernameExist(username, id)) {
                System.out.println("Username đã tồn tại. Nhập lại:");
                continue;
            }
            break;
        }

        boolean check = accountController.update(id, username);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update thất bại");
        }
    }

    public boolean checkExistDepartment(List<Department> departments, String id) {
        for (Department department : departments) {
            if (id.equals(String.valueOf(department.getId()))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExistPosition(List<Position> positions, String id) {
        for (Position position : positions) {
            if (id.equals(String.valueOf(position.getId()))) {
                return true;
            }
        }
        return false;
    }


    public  void findByIdAndName(){
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();

        List<Account> accounts = accountController.findByName(name);
        showAccount(accounts);
    }


}
