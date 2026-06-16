package org.example.utils;

import java.util.Objects;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+$";
    public static final String NUMBER_REGEX = "^[0-9]+$";
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final Integer ZERO = 0;

    // Nhập int
    // Tất cả đều nhập sc.next() ==> nhập ký tự
    // Convert sang kiểu dữ liệu phù hợp
    // trong trường hợp mà convert lỗi ==> nhảy vào catch ==> bắt người dùng lại
    public static int inputInt() {
        while (true) {
            try {
                // Nhập vào 1 chuỗi ký tự
                // Integer.parseInt ==> convert từ String sang Interger
                // TH1: Nếu nhập vào chuỗi là số nguyên ==> convert thành công
                // TH2: Nếu nhập vào chuỗi là ko số nguyên ==> có exception ==> Nhập lại
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Nhập lại...");
            }
        }
    }

    public static int inputID() {
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number > 0) {
                return number;
            } else {
                System.err.println("ID phải lớn hơn 0! Nhập lại:");
            }
        }
    }

    public static String inputString(String s) {
        String text;
        while (true) {
            text = scanner.nextLine();
            if (Objects.isNull(text) || text.trim().isEmpty()) {
                System.out.println("Nhập lại:");
            } else {
                return text;
            }
        }
    }
}


