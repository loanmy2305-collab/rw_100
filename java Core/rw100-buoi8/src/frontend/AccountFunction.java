package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import entity.Account;
import entity.Department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static backend.QLTK.accounts;

public class AccountFunction {
    private static Scanner scanner = new Scanner(System.in);

    public static void run() throws ClassNotFoundException, SQLException {
        List<Account> accounts = new ArrayList<>();
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Xem ds account");
            System.out.println("2. Thêm mới account");
            System.out.println("3. Xóa account theo tên");
            System.out.println("4. Update account theo ID");
            System.out.println("5. Tìm kiếm account họ tên");
            System.out.println("6. Thoát");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    accounts = QLAccount.findAllAccount();
                    showAccount(accounts);
                    break;
                case "2":
                    insertAccount();
                    break;
                case "3":
                    deleteAccount();
                    break;
                case "4":
                    updateAccount();
                    break;
                case "5":
                    findByIdAndName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Nhập sai, nhập lại.");
            }
        }
    }

    public static void findByIdAndName() {
        System.out.println("Nhập tên cần tìm: ");
        String name = scanner.nextLine();

        List<Account> accounts = QLAccount.findByName(name);
        showAccount(accounts);
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

    public static void showAccount(List<Account> accounts) {
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
}









