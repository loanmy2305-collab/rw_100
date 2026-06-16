package org.example.frontend;

import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    //private static StudentFunction studentFunction = new StudentFunction();
    //private static AccountFunction accountFunction = new AccountFunction();
    //private static LecturerFunction lecturerFunction = new LecturerFunction();

    public void run()  {
        while (true) {
            System.out.println("=== Mời bạn chọn chức năng ===");
            System.out.println("1. Làm việc với student");
            System.out.println("2. Làm việc với account");
            System.out.println("3. Làm việc với lecturer");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    StudentFunction studentFunction = new StudentFunction();
                    studentFunction.run();
                case "2":
                    AccountFunction accountFunction = new AccountFunction();
                    accountFunction.run();
                case "3":
                    LecturerFunction lecturerFunction = new LecturerFunction();
                    lecturerFunction.run();
                default:
                    System.out.println("Mời chọn lại");
            }
        }
    }

}

