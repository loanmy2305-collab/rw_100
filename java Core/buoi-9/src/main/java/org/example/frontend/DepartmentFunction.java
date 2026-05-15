package org.example.frontend;

import org.example.backend.controller.DepartmentController;
import org.example.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;

public class DepartmentFunction {
    private static Scanner scanner = new Scanner(System.in);
    //khởi tạo đối tượng controller
    private DepartmentController departmentController = new DepartmentController();

    public  void run() throws ClassNotFoundException {
        while (true) {
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
                    // lay ds phong ban tu controller
                    List<Department> departments = departmentController.findAll();
                    this.showDepartment(departments);
                    break;
                case "2":
                    this.insertDepartment();
                    break;
                case "3":
                    this.updateDepartment();
                    break;
                case "4":
                    this.deleteDepartment();
                    break;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }

    public void deleteDepartment() {
        System.out.println("Nhập ID phòng ban cần xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean check = departmentController.delete(id);
        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }

    public void insertDepartment() {
        System.out.println("Nhập tên phòng ban: ");
        String name = scanner.nextLine();
        boolean check = departmentController.insert(name);
        if (check) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Thêm không thành công");
        }
    }

    public void showDepartment(List<Department> departments) {
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

    public void updateDepartment() {
        System.out.println("Nhập ID phòng ban cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên phòng ban cần sửa: ");
        String name = scanner.nextLine();
        boolean check = departmentController.update(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }
}





