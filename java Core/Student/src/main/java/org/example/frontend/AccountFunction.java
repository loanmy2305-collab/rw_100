package org.example.frontend;

import org.example.backend.controller.StudentController;
import org.example.backend.service.IPasswordService;
import org.example.backend.service.impl.PasswordServiceImpl;
import org.example.entity.Student;
import org.example.utils.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private IPasswordService passwordService = new PasswordServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm sinh viên mới");
            System.out.println("3. Cập nhật chuyên ngành");
            System.out.println("4. Xóa sinh viên theo ID");
            System.out.println("5. Tìm sinh viên theo chuyên ngành");
            System.out.println("6. Tìm giảng viên theo ID");
            System.out.println("7. Kiểm tra Password");
            System.out.println("8. Exit");

            String choice = scanner.nextLine();
            switch (choice) {

                case "1":
                    this.checkPassword();
                    break;
                default:
                    System.out.println("nhập sai, nhập lại!");
            }
        }
    }
    public void checkPassword() {
        String password = ScannerUtils.inputString("Nhập password: ");

        boolean result = passwordService.checkPassword(password);

        System.out.println(result ? "Password hợp lệ!" : "Password không hợp lệ!");
    }



        }


