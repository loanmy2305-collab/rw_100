package frontend;

import backend.QLAccount;
import backend.QLDepartment;
import backend.QLTK;
import entity.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private  static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //QLTK.run();
       // QLDepartment.departmentHave2Employee();

        //  QLAccount.showAccount();
        // QLDepartment.showDepartment();
//        List<Department> departments = QLDepartment.findAllDepartment();
//        showDepartment(departments);
//        List<Department> departments1 = QLDepartment.findAllDepartment();
//        showDepartment(departments1);
        //insertDepartment();
        //deteleDepartment();
        //updateDepartment();
    }

    public static void updateDepartment() throws ClassNotFoundException{

        System.out.println("nhập ID phòng ban: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = QLDepartment.updateDepartment(id, name);
        if (check){
            System.out.println("update thành công");
        } else {
            System.out.println("update không thành công");
        }
    }

    public static void deteleDepartment() throws ClassNotFoundException{

        System.out.println("nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = QLDepartment.deteleDepartment(name);
        if (check){
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa không thành công");
        }
    }

    public static void insertDepartment() throws ClassNotFoundException{

        System.out.println("nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = QLDepartment.creatDepartment(name);
        if (check){
            System.out.println("thêm mới thành công");
        } else {
            System.out.println("thêm không thành công");
        }
    }

    public static void showDepartment(List<Department> departments) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên phòng ban");
        System.out.println("+-----+--------------------+");
        for (Department department : departments) {
            System.out.printf("|%5s|%20s|\n", department.getId(), department.getName());
        }
        if (departments.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }
}