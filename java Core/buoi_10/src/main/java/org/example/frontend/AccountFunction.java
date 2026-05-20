package org.example.frontend;

import org.example.backend.controller.AccountController;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);
    //khởi tạo đối tượng controller
    private AccountController accountController = new AccountController();

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
                    this.update();
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


    public  void insertAccount()  {
        String username;
        while (true) {
            System.out.print("Username: ");
            username = scanner.nextLine();

            // null hoặc rỗng
            if (username == null || username.trim().isEmpty()) {
                System.out.println("Username không được để trống!");
                continue;
            }

            // unique
            if (accountController.checkExistUsernameAndIdNot(username, null)) {
                System.out.println("Username đã tồn tại!");
                continue;
            }
            break;
        }

        String fullname;
        while (true) {
            System.out.print("Fullname: ");
            fullname = scanner.nextLine();
            if (fullname == null || fullname.trim().isEmpty()) {
                System.out.println("Fullname không được để trống!");
                continue;
            }
            break;
        }

        String email;

        while (true) {
            System.out.print("Email: ");
            email = scanner.nextLine();
            if (email == null || email.trim().isEmpty()) {
                System.out.println("Email không được để trống!");
                continue;
            }

            // check @
            if (!email.contains("@")) {
                System.out.println("Email phải chứa @");
                continue;
            }

            // unique
            if (accountController.checkExistEmailAndIdNot(email, null)) {
                System.out.println("Email đã tồn tại!");
                continue;
            }
            break;
        }

        int depId;

        while (true) {
            System.out.print("Department ID: ");
            depId = Integer.parseInt(scanner.nextLine());
            if (depId <= 0) {
                System.out.println("Department ID phải > 0");
                continue;
            }
            if (!accountController.checkExistDepartmentID(depId)) {
                System.out.println("Department không tồn tại!");
                continue;
            }
            break;
        }

        int posId;
        while (true) {
            System.out.print("Position ID: ");
            posId = Integer.parseInt(
                    scanner.nextLine());
            if (posId <= 0) {
                System.out.println("Position ID phải > 0");
                continue;
            }
            if (!accountController.checkExistPositionID(posId)) {
                System.out.println("Position không tồn tại!");
                continue;
            }
            break;
        }
        Account acc = new Account();

        acc.setUsername(username);
        acc.setFullName(fullname);
        acc.setEmail(email);

        Department dep = new Department();
        dep.setId(depId);

        acc.setDepartment(dep);

        Position pos = new Position();
        pos.setId(posId);

        acc.setPosition(pos);

        acc.setCreateDate(java.time.LocalDate.now());

        boolean check = accountController.insert(acc);

        if (check) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }

    public  void deleteAccount()  {

        System.out.print("Nhập ID cần xóa: ");
        int id;

        while (true) {
            id = Integer.parseInt(scanner.nextLine());

            // > 0
            if (id <= 0) {
                System.out.println("ID phải > 0");
                continue;
            }

            // tồn tại
            if (!accountController.checkExistID(id)) {
                System.out.println("ID không tồn tại!");
                continue;
            }
            break;
        }

        boolean check = accountController.deleteAccount(id);
        if (check) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }

    public  void update() {

        int id;
        while (true) {
            System.out.print("Nhập ID cần sửa: ");
            id = Integer.parseInt(scanner.nextLine());

            // > 0
            if (id <= 0) {
                System.out.println("ID phải > 0");
                continue;
            }

            // tồn tại
            if (!accountController.checkExistID(id)) {
                System.out.println("ID không tồn tại!");
                continue;
            }
            break;
        }

        String newUsername;

        while (true) {
            System.out.print("Username mới: ");

            newUsername = scanner.nextLine();

            if (newUsername == null || newUsername.trim().isEmpty()) {
                System.out.println("Username không được để trống!");
                continue;
            }

            // unique
            if (accountController.checkExistUsernameAndIdNot(newUsername, id)) {
                System.out.println("Username đã tồn tại!");
                continue;
            }
            break;
        }
        boolean check = accountController.updateUsername(id, newUsername);
        if (check) {
            System.out.println("Update thành công!");
        } else {
            System.out.println("Update thất bại!");
        }
    }


    public  void findByIdAndName(){
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();

        List<Account> accounts = accountController.findByName(name);
        showAccount(accounts);
    }

    
}
