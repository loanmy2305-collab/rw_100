package org.example.frontend;

import org.example.backend.controller.StudentController;
import org.example.backend.service.IStudentService;
import org.example.backend.service.impl.StudentServiceImpl;
import org.example.entity.Student;
import org.example.utils.ScannerUtils;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class StudentFunction {
    private static Scanner scanner = new Scanner(System.in);
    private StudentController studentController = new StudentController();

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
                    List<Student> students = studentController.findAll();
                    this.showStudent(students);
                    break;
                case "2":
                    this.create();
                    break;
                case "3":
                    this.updateMajorId();
                    break;
                case "4":
                    this.deleteById();
                    break;
                case "5":
                    this.findByMajorName();
                    break;
                default:
                    System.out.println("Chọn sai, chọn lại!");
            }
        }
    }


    public void create() {
        String fullName = ScannerUtils.inputString("Nhập họ tên: ");
        String email = ScannerUtils.inputString("Nhập email: ");
        Date birthDate = Date.valueOf(ScannerUtils.inputString("Nhập ngày sinh yyyy-mm-dd: "));
        int majorId = Integer.parseInt(ScannerUtils.inputString("Nhập ID chuyên ngành: "));

        if (studentController.checkExistEmail(email)) {
            System.out.println("Email đã tồn tại!");
            return;
        }
        boolean result = studentController.create(fullName, email, birthDate, majorId);
        System.out.println(result ? "Thêm thành công!" : "Thêm thất bại!");
    }

    public void updateMajorId() {
        int studentId = Integer.parseInt(ScannerUtils.inputString("Nhập ID sinh viên: "));
        int majorId = Integer.parseInt(ScannerUtils.inputString("Nhập ID chuyên ngành mới: "));

        boolean result = studentController.updateMajorId(studentId, majorId);

        System.out.println(result ? "Cập nhật thành công!" : "Cập nhật thất bại!");
    }

    public void deleteById() {
        int studentId = Integer.parseInt(ScannerUtils.inputString("Nhập ID sinh viên cần xóa: "));

        boolean result = studentController.deleteById(studentId);

        System.out.println(result ? "Xóa thành công!" : "Không tìm thấy sinh viên!");
    }

    public void findByMajorName() {
        String majorName = ScannerUtils.inputString("Nhập tên chuyên ngành: ");

        List<Student> students = studentController.findByMajorName(majorName);

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void showStudent(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên nào.");
            return;
        }
        System.out.println("ID | Họ tên | Email | Ngày sinh | Chuyên ngành");
        for (Student student : students) {
            System.out.println(student);
        }
    }

}


