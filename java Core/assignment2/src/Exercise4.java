import java.time.LocalDate;
import java.util.Random;

public class Exercise4 {
    public static void main(String[] args) {

        // Question 1:
        //In ngẫu nhiên ra 1 số nguyên

        Random random = new Random();
        int number = random.nextInt();
        System.out.println("số nguyên là:" + number);

        // Question2:In ngẫu nhiên ra 1 số thực


        double a = random.nextInt();
        System.out.println("số thực là:" + a);

        //Question3:Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn

        // Question4:Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995

        int minDay = (int) LocalDate.of(1995, 07, 24).toEpochDay();
        int maxDay = (int) LocalDate.of(1995, 12, 20).toEpochDay();
        long randomInt = minDay + random.nextInt(maxDay - minDay);
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

    }


}

