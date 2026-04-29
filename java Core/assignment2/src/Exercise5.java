import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exercise5 {

    // Question 1:Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
    public static void question1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên 1: ");
        int a = scanner.nextInt();
        System.out.print("Nhập số nguyên 2: ");
        int b = scanner.nextInt();
        System.out.print("Nhập số nguyên 3: ");
        int c = scanner.nextInt();
        System.out.println("Bạn đã nhập: " + a + ", " + b + ", " + c);
    }

    //Question 2:
    //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
    public static void question2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên 1: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập số nguyên 2: ");
        double b = scanner.nextDouble();
        System.out.println("Bạn đã nhập: " + a + "," + b );
    }
    //
    //Question 3:
    //Viết lệnh cho phép người dùng nhập họ và tên
    public static void question3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập họ và tên: ");
        String fullname = scanner.nextLine();
        System.out.println("Họ tên: " + fullname);
    }

    //Question 4:
    //Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
    public static void question4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập ngày sinh nhật: ");
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-DD :");
        LocalDate birthday = LocalDate.parse(input, formatter);
        System.out.println("Ngày sinh của bạn: " + birthday);
    }

    //Question 5:
    //Viết lệnh cho phép người dùng tạo account (viết thành method) Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào chương trình sẽ chuyển thành Position.Dev, Position.Test, Position.ScrumMaster, Position.PM

    //Question 6:
    //Viết lệnh cho phép người dùng tạo department (viết thành method)
    //
    //Question 7:
    //Nhập số chẵn từ console
    //
    //Question 8:
    //Viết chương trình thực hiện theo flow sau:
    //Bước 1:  Chương trình in ra text "mời bạn nhập vào chức năng muốn sử dụng"
    //Bước 2:  Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
    //Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo department
    //Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập lại" và quay trở lại bước 1
    //
    //Question 9:
    //Viết method cho phép người dùng thêm group vào account theo flow sau:
    //Bước 1: In ra tên các usernames của user cho người dùng xem
    //Bước 2: Yêu cầu người dùng nhập vào username của account
    //Bước 3:  In ra tên các group cho người dùng xem
    //Bước 4: Yêu cầu người dùng nhập vào tên của group
    //Bước 5:  Dựa vào username và tên của group người dùng vừa chọn, hãy thêm account vào group đó .
    //
    //Question 10: Tiếp tục Question 8 và Question 9
    //Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào account
    //Bổ sung thêm Bước 3 của Question 8 như sau:
    //Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để kết thúc chương trình)
    //
    //Question 11: Tiếp tục Question 10 Bổ sung thêm vào bước 2 của Question 8 như sau:
    //Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
    //Bước 1:  In ra tên các usernames của user cho người dùng xem
    //Bước 2:  Yêu cầu người dùng nhập vào username của account
    //Bước 3: Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
    //Bước 4:  Thêm account vào group chương trình vừa chọn ngẫu nhiên

}