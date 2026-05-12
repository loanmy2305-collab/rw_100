package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import entity.Account;
import entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws SQLException, ClassNotFoundException {
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
                    List<Account> accounts = QLAccount.findAllAccount();
                    showAccounts(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    updateAccount();
                    break;
                case "4":
                    deleteAccount();
                    break;
                case "5":
                    findByfullName();
                    break;
                case "6":
                    findByfullNameAndUsername();
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }


    public static void findByfullName() throws SQLException, ClassNotFoundException {
        System.out.print("Nhập đầy đủ tên cần tìm: ");
        String fullName = scanner.nextLine();
        List<Account> accounts = QLAccount.findByfullName(fullName);
        showAccounts(accounts);
    }

    public static void findByfullNameAndUsername() throws SQLException, ClassNotFoundException {
        System.out.print("Nhập đầy đủ tên cần tìm: ");
        String fullName = scanner.nextLine();
        System.out.print("Nhập username cần tìm: ");
        String username = scanner.nextLine();
        List<Account> accounts = QLAccount.findByfullNameAndUsername(fullName, username);
        showAccounts(accounts);
    }


    public static void insertAccount() throws ClassNotFoundException {
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


        if (QLAccount.creatAccount(email, username, fullName, depId, posId)) {
            System.out.println("Thêm tài khoản thành công!");
        } else {
            System.out.println("Thêm tài khoản không thành công!");
        }
    }

    public static void deleteAccount() throws ClassNotFoundException {

        System.out.println("nhập id cần xóa: ");
        int id = scanner.nextInt();
        boolean check = QLAccount.deleteAccount(id);
        if (check) {
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa không thành công");
        }
    }

    public static void updateAccount() throws ClassNotFoundException {

        System.out.println("nhập id tai khoản: ");
        int id = scanner.nextInt();

        System.out.println("department_Id: ");
        int depId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("position_Id: ");
        int posId = scanner.nextInt();
        scanner.nextLine();

        boolean check = QLAccount.updateAccount(id, depId, posId);
        if (check) {
            System.out.println("update thành công");
        } else {
            System.out.println("update không thành công");
        }
    }

    public static void showAccounts(List<Account> accounts) {
        System.out.println("\n+------+----------------------+----------------------+----------------------+----------------------+----------------------+");
        System.out.printf("|%5s|%20s||%5s|%20s|%20s|%20s|\n",
                "ID", "Email", "Username", "Full Name", "Department", "Position");
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+----------------------+");

        for (Account acc : accounts) {
            System.out.printf("|%5s|%20s||%20s|%20s|%20s|%20s|\n",
                    acc.getId(),
                    acc.getEmail(),
                    acc.getUsername(),
                    acc.getFullName(),
                    (acc.getDepartment() != null ? acc.getDepartment().getName() : "N/A"),
                    (acc.getPosition() != null ? acc.getPosition().getName() : "N/A")
            );
        }

        if (accounts.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+------+----------------------+----------------------+----------------------+----------------------+----------------------+");
    }
}









