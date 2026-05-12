package frontend;

import backend.QLDepartment;
import entity.Department;

import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private  static Scanner scanner = new Scanner(System.in);
    public static void run() throws ClassNotFoundException {
        while (true){
            System.out.println("=== mời bạn chọn chức năng ===");
            System.out.println("1.xem ds phòng ban");
            System.out.println("2.them mới phòng ban");
            System.out.println("3.update phòng ban");
            System.out.println("4.xóa phòng ban");
            System.out.println("5.tìm kiếm phòng ban");
            System.out.println("6.thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Department> departments = QLDepartment.findAllDepartment();
                    showDepartment(departments);
                    break;
                case "2":
                    insertDepartment();
                    break;
                case "3":
                    updateDepartment();
                    break;
                case "4":
                    deleteDepartment();
                    break;
                case "5":
                    findDepartmentByNameAndId();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }

    public static void findDepartmentByNameAndId() throws ClassNotFoundException {
        System.out.println("Nhập ID cần tìm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên phòng ban cần tìm: ");
        String name = scanner.nextLine();
        java.util.List<Department> departments = QLDepartment.findByNameAndId(name, id);
        showDepartment(departments);
    }

    public static void updateDepartment() throws ClassNotFoundException {
        System.out.println("Nhập ID phòng ban cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên phòng ban cần sửa: ");
        String name = scanner.nextLine();
        boolean check = QLDepartment.updateDepartment(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }

    public static void deleteDepartment() throws ClassNotFoundException{

        System.out.println("nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = QLDepartment.deleteDepartment(name);
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




