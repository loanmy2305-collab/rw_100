package org.example.frontend;

import org.example.backend.service.ILecturerService;
import org.example.backend.service.impl.LecturerServiceimpl;
import org.example.entity.Lecturer;
import org.example.utils.ScannerUtils;

import java.util.Scanner;

public class LecturerFunction {
    private ILecturerService lecturerService = new LecturerServiceimpl();
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
                    this.findById();
                    break;
                default:
                    System.out.println("nhập sai, nhập lại!");
            }
        }
    }

    public void findById() {
        int id = Integer.parseInt(ScannerUtils.inputString("Nhập ID giảng viên: "));

        Lecturer lecturer = lecturerService.findById(id);

        if (lecturer == null) {
            System.out.println("Không tìm thấy giảng viên!");
        } else {
            System.out.println(lecturer);
        }
    }
}
