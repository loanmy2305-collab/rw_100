package org.example.frontend;

import org.example.backend.controller.AccountController;
import org.example.backend.controller.DepartmentController;
import org.example.entity.Account;

import java.sql.SQLException;
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
        System.out.println("Nhập thông tin tài khoản mới: ");
        System.out.println("email: ");
        String email = scanner.nextLine();
        System.out.println("fullName: ");
        String fullName = scanner.nextLine();
        System.out.println("username: ");
        String username = scanner.nextLine();
        System.out.println("department_Id: ");
        int depId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("position_Id: ");
        int posId = scanner.nextInt();
        scanner.nextLine();


        if (accountController.insert(email, username, fullName, depId, posId)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Thêm tài khoản không thành công!");
        }
    }

    public  void deleteAccount()  {

        System.out.println("nhập id cần xóa: ");
        int id = scanner.nextInt();
        boolean check = accountController.deleteAccount(id);
        if (check) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa không thành công");
        }
    }

    public  void update() {

        System.out.println("nhập id tai khoản: ");
        int id = scanner.nextInt();

        System.out.println("department_Id: ");
        int depId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("position_Id: ");
        int posId = scanner.nextInt();
        scanner.nextLine();

        boolean check = accountController.update(id, depId, posId);
        if (check) {
            System.out.println("update thành công");
        } else {
            System.out.println("update không thành công");
        }
    }

    public  void findByIdAndName(){
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();

        List<Account> accounts = accountController.findByName(name);
        showAccount(accounts);
    }




}
