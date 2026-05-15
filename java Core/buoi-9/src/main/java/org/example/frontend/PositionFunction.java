package org.example.frontend;

import org.example.backend.controller.DepartmentController;
import org.example.backend.controller.PositionController;
import org.example.entity.Position;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PositionFunction {

    private  static Scanner scanner = new Scanner(System.in);

    private PositionController positionController = new PositionController();
    public void run() throws ClassNotFoundException, SQLException {
        while (true){
            System.out.println("=== mời bạn chọn chức năng ===");
            System.out.println("1.xem ds chức vụ ");
            System.out.println("2.them mới chức vụ");
            System.out.println("3.update chức vụ");
            System.out.println("4.xóa chức vụ");
            System.out.println("5.tìm kiếm chức vụ");
            System.out.println("6.thoát");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    List<Position> positions = positionController.findAll();
                    this.showPosition(positions);
                    break;
                case "2":
                    this.insert();
                    break;
                case "3":
                    this.updatePosition();
                    break;
                case "4":
                    this.deletePosition();
                    break;
                case "5":
                    this.findByName();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }

    public  void showPosition(List<Position> positions) {
        System.out.println("+-----+--------------------+");
        System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
        System.out.println("+-----+--------------------+");
        for (Position position : positions) {
            System.out.printf("|%5s|%20s|\n", position.getId(), position.getName());
        }
        if (positions.size() == 0) {
            System.out.println("Không tìm thấy");
        }
        System.out.println("+-----+--------------------+");
    }

    public  void insert() {

        System.out.println("nhập tên chức vụ: ");
        String name = scanner.nextLine();
        boolean check = positionController.insert(name);
        if (check){
            System.out.println("thêm mới thành công");
        } else {
            System.out.println("thêm không thành công");
        }
    }

    public  void deletePosition() {

        System.out.println("nhập id chức vụ: ");
        int id = scanner.nextInt();
        boolean check = positionController.deletePosition(id);
        if (check){
            System.out.println("xóa thành công");
        } else {
            System.out.println("xóa không thành công");
        }
    }

    public  void updatePosition()  {
        System.out.println("Nhập ID  chức vụ cần sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Nhập tên chức vụ cần sửa: ");
        String name = scanner.nextLine();
        boolean check = positionController.updatePosition(id, name);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }

    public  void findByName() throws ClassNotFoundException, SQLException {
        System.out.print("Nhập tên chuc vụ tìm kiếm: ");
        String name = scanner.nextLine();
        List<Position> positions = positionController.findByName(name);
        showPosition(positions);
    }


}
