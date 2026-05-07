package backend;
// Xây dựng quản lý phòng ban Department và Position và Account
//1.thêm phòng ban
//2.thêm chức vụ
//3.thêm account (phải có khóa ngoại dep và pos)-createDate là now
//4.xem ds phòng ban
//5.xem ds chức vụ
//6.xem ds account (id,fullnam,email,username,tên phòng ban,tên chức vụ,ngày tạp)
//7. tìm kiếm account theo tên phòng vụ
//8.tìm kiếm account theo tên chức vụ
//9.xóa account theo fullname.

import entity.Account;
import entity.Department;
import entity.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void department() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Account> accounts = new ArrayList<>();
        ArrayList<Position> positions = new ArrayList<>();
        while (true) {
            System.out.println("====Mời bạn chọn chức năng====");
            System.out.println("1.Thêm phòng ban");
            System.out.println("2.Thêm chức vụ");
            System.out.println("3.Thêm account");
            System.out.println("4. Xem danh sách phòng ban");
            System.out.println("5. Xem danh sách chức vụ");
            System.out.println("6. Xem danh sách account");
            System.out.println("7. Tìm account theo phòng ban");
            System.out.println("8. Tìm account theo chức vụ");
            System.out.println("9. Xóa account theo fullname");
            System.out.println("0. Thoát");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("chức năng thêm mới phòng ban");
                    System.out.println("Nhâập id phòng ban");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên phòng ban");
                    String name = scanner.nextLine();

                   Department department = new Department(id,name);
                    departments.add(department);
                    System.out.println("thêm phòng ban thành công");
                    break;
                case 2:
                    System.out.println("chức năng thêm mới chức vụ");
                    System.out.println("nhập id chức vụ");
                    int positionId = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập tên phòng ban:DEV, TEST, SCRUM_MASTER, PM");
                    String positionNameChoose = scanner.nextLine();
                    Position.PositionName positionName;
                    switch (positionNameChoose){
                        case "1":
                            positionName = Position.PositionName.DEV;
                            break;
                        case "2":
                            positionName = Position.PositionName.TEST;
                            break;
                        case "3":
                            positionName = Position.PositionName.SCRUM_MASTER;
                            break;
                        default:
                            positionName = Position.PositionName.PM;
                    }

                    Position position = new Position(positionId,positionName);
                    positions.add(position);
                    System.out.println("thêm chức vụ thành công");
                    break;
                case 3:
                    System.out.println("chức năng thêm mới account");
                    System.out.println("nhập id account");
                    int accountId = Integer.parseInt(scanner.nextLine());
                    System.out.println("nhập email");
                    String email = scanner.nextLine();
                    System.out.println("nhâp username");
                    String username = scanner.nextLine();
                    System.out.println("nhâp fullname");
                    // department
                    break;
                case 4:
                    System.out.println("Xem danh sách phòng ban");
                    for (Department department1 : departments) {
                        System.out.println(department1.getId() + " " + department1.getName());
                    }
                    System.out.println("=========");
                    break;
                case 5:
                    System.out.println("Xem danh sách chức vụ");
                    for (Position position1 : positions) {
                        System.out.println(position1.getId() + " " + position1.getName());
                    }
                    System.out.println("=========");
                    break;
                case 6:
                    System.out.println("XXem danh sách account");
                    for (Account account : accounts){
                        System.out.println("id :" + account.getId());
                        System.out.println("email :" + account.getEmail());
                        System.out.println("fullname :" + account.getFullname());
                        System.out.println("username :" + account.getUsername());
                        System.out.println("Department :" + account.getDepartment());
                        System.out.println("position :" + account.getPosition());
                        System.out.println("createDate :" + account.getCreateDate());
                    }
                    System.out.println("=========");
                    break;
                case 7:
                    System.out.println("Tìm account theo phòng ban");
                    System.out.println("nhập tên phòng ban:");
                    String depName = scanner.nextLine();
                    for (Account account : accounts){
                        if (account.getDepartment().getName().equalsIgnoreCase(depName)){
                            System.out.println(account.getFullname());
                        }
                    }

                    break;
                case 8:
                    System.out.println("Tìm account theo chức vụ");
                    System.out.println("nập tên chức vụ:");
                    String posName = scanner.nextLine();
                    for (Account account : accounts){
                        if (account.getPosition().getName().equals(posName)){
                            System.out.println(account.getFullname());
                        }
                    }
                    break;
                case 9:
                    System.out.println("Xóa account theo fullname");
                    System.out.println("nhập fullname cần xóa");
                    String fullName = scanner.nextLine();

                    break;
                case 10:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Mời bạn nhập lại!!");
            }
        }







    }


























}
