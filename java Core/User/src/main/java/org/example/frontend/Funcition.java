package org.example.frontend;

import org.example.backend.controller.UserController;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.utils.ScannerUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Funcition {
    private Scanner sc = new Scanner(System.in);
    private UserController controller = new UserController();


    public void menuEmployee() {
        while (true) {
            System.out.println("=== MENU EMPLOYEE ===");
            System.out.println("1. Hiển thị toàn bộ user");
            System.out.println("2. Tìm kiếm");
            System.out.println("3. Xóa ");
            System.out.println("4. Thoát ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.showAll();
                    break;
                case "2":
                    this.findById();
                    break;
                case "3":
                    this.deleteId();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }

    public void menuAdmin() {
        while (true) {
            System.out.println("=== MENU ADMIN ===");
            System.out.println("1. Hiển thị toàn bộ user");
            System.out.println("2. Tìm kiếm");
            System.out.println("3. Xóa ");
            System.out.println("4. Tạo employee ");
            System.out.println("5. Thoát ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.showAll();
                    break;
                case "2":
                    this.findById();
                    break;
                case "3":
                    this.deleteId();
                    break;
                case "4":
                    this.createEmployee();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }

    private void deleteId() {
        System.out.println("Nhập id cần xóa:");
        Long id = (long) ScannerUtils.inputID();
        boolean check = controller.deleteId(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    private void findById() {
        System.out.println("Nhập id cần tìm:");
        Long id = (long) ScannerUtils.inputID();
        User user = controller.findById(id);
        if (user != null) {
//            List<User> users = new ArrayList<>();
//            users.add(user);
//            this.showUser(users);
            this.showUser(Arrays.asList(user));
        } else  {
            System.out.println("Không tìm thấy user này");
        }
    }

    private void showAll() {
        List<User> users = controller.findAll();
        this.showUser(users);
    }

    private void createEmployee() {
        System.out.println("Nhập email: ");
        String email = "";
        while (true) {
            email = ScannerUtils.inputEmail();// dinh dạng
            if (controller.checkExistEmail(email)) {// kiem tra ton tai chua
                System.out.println("Email này đã được sử dụng. Nhập lại:");
                continue;
            }
            break;
        }
        System.out.println("Nhập fullName: ");
        String fullName = ScannerUtils.inputFullName();

        boolean checkCreate = controller.create(fullName, email);
        if (checkCreate) {
            System.out.println("Tạo thành công, password là 123456A");
        } else {
            System.out.println("Tạo không thành công");
        }
    }

    public void login() {
        User user = null;
        while (true) {
            System.out.println("Nhập email: ");
            String email = ScannerUtils.inputEmail();
            System.out.println("Password: ");
            String password = ScannerUtils.inputPassword();

            user = controller.login(email, password);
            if (user == null) {
                System.out.println("Sai thông tin đăng nhập");
            } else {
                break;
            }
        }
        if (user.getRole() == Role.ADMIN) {
            this.menuAdmin();
        } else {
            this.menuEmployee();
        }
    }

    public void showUser(List<User> users) {
        System.out.println("+-----+--------------------+--------------------+");
        System.out.printf("|%5s|%20s|%20s|\n", "ID", "FullName", "Email");
        System.out.println("+-----+--------------------+--------------------+");
        for (User user : users) {
            System.out.printf("|%5s|%20s|%20s|\n", user.getId(), user.getFullName(), user.getEmail());
        }
        if (users.isEmpty()) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+--------------------+");
    }


}
