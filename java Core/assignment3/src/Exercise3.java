public class Exercise3 {

    // Question 1: Khởi tạo lương có datatype là Integer có giá trị bằng 5000. Sau đó convert lương ra float và hiển thị lương lên màn hình (với số float có 2 số sau dấu thập phân)

    public static void question1(){
        Integer luong = 5000;
        float luongFloat = luong.floatValue();
        System.out.println("lương là: %.2f" + luongFloat);

    }

    //Question 2:
    //Khai báo 1 String có value = "1234567"
    //Hãy convert String đó ra số int
    public static void question2(){
        String value = "1234567";
        int number = Integer.parseInt(value);
        System.out.println("số int là: " + number);
    }

    //Question 3:
    //Khởi tạo 1 số Integer có value là chữ "1234567"
    //Sau đó convert số trên thành datatype int
    public static void question3() {
        Integer numberInteger = Integer.valueOf("1234567");
        int number = numberInteger.intValue();
        System.out.println("số in là: " + number);
    }






}

