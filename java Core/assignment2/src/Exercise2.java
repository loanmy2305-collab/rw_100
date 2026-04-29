import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise2 {
    public static void main(String[] args) {

        //question1:Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
        int number = 5;
        System.out.printf("số nguyên là:" + number);
        // question2:Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in ra số nguyên đó thành định dạng như sau: 100,000,000

        int a = 100000;
        System.out.println("số nguyên là %d : " + a);

        // question3:Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số thực đó chỉ bao gồm 4 số đằng sau

        double b = 5.567098;
        System.out.printf("%5.4f", b);


        //Question 4:
        //Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
        //Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        //Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.

        String name = "Nguyễn Văn A";
        System.out.printf("tn tôi là " + name + "tôi đang độc thân");


        //Question 5:
        //Lấy thời gian bây giờ và in ra theo định dạng sau:
        //24/04/2020 11h:16p:20s
        Date now = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("Thời gian hiện tại là:" + simpleDateFormat);
    }
}


// Question 6:
//In ra thông tin account (như Question 8 phần FOREACH) theo định dạng table (giống trong Database)