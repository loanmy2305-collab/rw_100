package org.example.frontend;

import org.example.backend.controller.PositionController;
import org.example.entity.Position;
import org.example.enums.PositionName;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PositionFunction {

    private static Scanner scanner = new Scanner(System.in);

    private PositionController positionController = new PositionController();

    public void run() throws ClassNotFoundException, SQLException {
        while (true) {
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
                    this.insertPosition();
                    break;
                case "3":
                    this.deletePosition();
                    break;
                case "4":
                    this.updatePosition();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Chọn sai, chọn lại!");

            }
        }
    }

    public void showPosition(List<Position> positions) {
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

    public void insertPosition() {
            PositionName name = null;
            while (true) {
                System.out.println("Nhập position mới: 1.DEV 2.TEST  3.SCRUM_MASTER 4.PM");
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        name = PositionName.DEV;
                        break;
                    case "2":
                        name = PositionName.TEST;
                        break;
                    case "3":
                        name = PositionName.SCRUM_MASTER;
                        break;
                    case "4":
                        name = PositionName.PM;
                        break;
                    default:
                        name = PositionName.PM;
                }
                // check position đã tồn tại chưa
                if (positionController.checkExistNameAndIdNot(String.valueOf(name), null)) {
                    System.out.println("Position đã tồn tại, nhập lại");
                    continue;
                }
                break;
            }
            boolean check = positionController.insert(String.valueOf(name));
            if (check) {
                System.out.println("Thêm mới thành công");
            } else {
                System.out.println("Thêm mới thất bại");
            }

        }


    public void updatePosition () {
            Integer id;
            while (true) {
                System.out.println("Nhập id cần sửa:");
                id = scanner.nextInt();
                scanner.nextLine();
                if (id <= 0) {
                    System.out.println("Id không hợp lệ");
                    continue;
                }
                if (!positionController.checkExistID(id)) {
                    System.out.println("Id không tồn tại");
                    continue;
                }
                break;
            }
            PositionName name = null;
            while (true) {
                System.out.println("Nhập position mới: 1.DEV 2.TEST  3.SCRUM_MASTER 4.PM");

                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        name = PositionName.DEV;
                        break;
                    case "2":
                        name = PositionName.TEST;
                        break;
                    case "3":
                        name = PositionName.SCRUM_MASTER;
                        break;
                    default:
                        name = PositionName.PM;

                }

                // check unique
                if (positionController.checkExistNameAndIdNot(String.valueOf(name), id)) {
                    System.out.println("Position đã tồn tại");
                    continue;
                }
                break;
            }
            boolean check = positionController.updatePosition(id, String.valueOf(name));
            if (check) {
                System.out.println("Sửa thành công");
            } else {
                System.out.println("Sửa thất bại");

            }


        }

    public void deletePosition() {
        Integer id;
        while (true) {
            System.out.println("Nhập id position cần xóa:");
            id = scanner.nextInt();
            scanner.nextLine();
            // check id >0
            if (id <= 0) {
                System.out.println("Id lớn hơn 0");
                continue;
            }
            // check id tồn tại
            if (!positionController.checkExistID(id)) {
                System.out.println("Id không tồn tại");
                continue;
            }
            break;
        }
        boolean check = positionController.deletePosition(id);

        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }
    }


