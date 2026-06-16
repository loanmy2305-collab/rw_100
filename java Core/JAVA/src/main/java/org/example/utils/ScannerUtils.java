package org.example.utils;

import com.mysql.cj.util.StringUtils;

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

    // Nhập float
    public static Float inputFloat() {
        while (true) {
            try {
                return Float.parseFloat(scanner.next());
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }

    public static Double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.next());
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }

    // Chọn chức năng
    public static int inputIntPositive() {
        while (true) {
            try {
                int intPositive = Integer.parseInt(scanner.nextLine());
                if (intPositive >= 0) {
                    return intPositive;
                } else {
                    System.err.println("Nhập lại:");
                }
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }

    public static String inputString() {
        while (true) {
            String string = scanner.nextLine();
            if (!StringUtils.isNullOrEmpty(string)) {// isEmty ==> rỗng ; !isEmpty() ==> không rỗng
//				System.out.println(string);
                return string;
            } else {
                System.err.println("Nhập lại:");
            }
        }
    }

    public static String inputPassword() {
        while (true) {
            String password = ScannerUtils.inputString();
            if (password.length() < 6 || password.length() > 12) {
                System.out.print("Nhập lại: ");
                continue;
            }
            boolean hasAtLeast1Character = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    hasAtLeast1Character = true;
                    break;
                }
            }

            if (hasAtLeast1Character) {// password dung
                return password;
            } else {
                System.out.print("Mời bạn nhập lại password: ");
            }
        }
    }

    // Ctrl + Shift + O ==> import thư viện  kiem tra dinh dang email
    public static String inputEmail() {
        while (true) {
            String email = scanner.nextLine();// equals(); so sanh gtri,   == so sánh địa chỉ ,  biểu thức chính quy, matches(): so sánh  theo quy tắc
            if (email == null || !email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {// a@b
                System.out.print("Nhập lại: ");
            } else {
                return email;
            }
        }
    }

    // Hàm nhập fullName chỉ chứa chữ, không chứa bất kì ký tự đặc biệt nào
    public static String inputFullName() {
        while (true) {
            String fullName = ScannerUtils.inputString();
            if (fullName == null
                    || !fullName.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ"
                    + "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨú"
                    + "ÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ \\\\ _-]{3,25}$")) {

                System.out.println("Nhập lại: ");

            } else {
                return fullName;
            }
        }
    }

    public static int inputFunction(int a, int b) {// bat
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number >= a && number <= b) {
                return number;
            } else {
                System.err.println("chỉ được nhập từ " + a + " đến " + b);
            }
        }
    }

    public static String inputPhoneNumber() {

        while (true) {
            boolean isNumber = true;
            String number = ScannerUtils.inputString();


            if (number.charAt(0) != '0') {
                isNumber = false;
            }
            if (number.length() > 12 || number.length() < 9) {
                isNumber = false;
            }

            // kiem tra co ki tu nao ko  phải la number ko
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))) {//isDigit kiem tra 1 kí tu co phai so hay ko
                    isNumber = false;
                    break;
                }
            }
            if (isNumber == true) {// sdt hop le
                return number;
            } else {
                System.out.print("Nhập lại: ");
            }
        }
    }
}
