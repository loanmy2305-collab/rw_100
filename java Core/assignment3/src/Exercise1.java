import java.util.Random;
import java.util.Scanner;

public class Exercise1 {

//    Question 1:
        //    Khai báo 2 số lương có kiểu dữ liệu là float.
        //    Khởi tạo Lương của Account 1 là 5240.5 $
        //    Khởi tạo Lương của Account 2 là 10970.055$
        //
        //    Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
        //    Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
    public static void question1(Account account){
        float a = 5240.5f;
        float b = 510970.055f;

        int rounda = (int) a;
        int roundb = (int) b;
        System.out.println("lương của Account1 là: " + rounda);
        System.out.println("lương của Account2 là: " + roundb);
    }
    //Question 2:
    //Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
    public static void question2(){
        Random random = new Random();
        int numer = random.nextInt(100000);
        System.out.println("số có 5 chữ số là: " + numer);
    }

    //Question 4:
    //Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng

    public static double doublethuong(int a, int b) {
        return (double) a / b;
    }
    public static void question4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập a là: ");
        int a = scanner.nextInt();
        System.out.println("nhập b là: ");
        int b = scanner.nextInt();
        double thuong = doublethuong(a, b);
        System.out.println("thương cu a và b là:" + thuong);


    }
}
