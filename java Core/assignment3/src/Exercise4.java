import java.util.Scanner;

public class Exercise4 {
    // Question 1:
    //Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó
    // (các từ có thể cách nhau bằng nhiều khoảng trắng );

    public static void question1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập xâu kí tự là: ");
        String a = scanner.nextLine();
        a.trim();
        String[] words = a.trim().split("\\s+ ");
        System.out.println("số lượng các từ: " + words.length);
        for (String aa: words);
            System.out.println(a);
    }

    // Question 2:
    //Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
    public static void question2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("xâu kí tự s1:");
        String s1 = scanner.nextLine();
        System.out.print("xâu kí tự s2:");
        String s2 = scanner.nextLine();
        // nối chuỗi
        String result = s1 + s2;
        System.out.println("chuỗi sau khi nối là: " + result);
    }

    //Question 3:
    //Viết chương trình để người dùng nhập vào tên và kiểm tra,
    // nếu tên chư viết hoa chữ cái đầu thì viết hoa lên
    public static void question3() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập tên là:");
        String name = scanner.nextLine();
        // cắt chuỗi -> mảng từng từ
        //viết hoa chữ cái đầu tiên của từng từ
        // coojgn lại với nhau
        String[] names = name.trim().split("\\s+");
       StringBuilder stringBuilder = new StringBuilder();
        for (String s: names){
            System.out.println(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");

        }

    }

    //Question 5:
    //Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
    public static void question4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập họ là: ");
        String name1 = scanner.nextLine();
        System.out.print("nhập tên là: ");
        String name2 = scanner.nextLine();
        System.out.println("nhập họ và tên là: " + name1 + " " + name2);
    }

    // Question 8:
    //In ra tất cả các group có chứa chữ "Java"
    public static void question8(Group group) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("In ra tất cả các group có chứa chữ \"Java\" là: ");
        Group group1 = new Group();
        group1.name = "Java";
        Group group2 = new Group();
        group2.name = "Python";
        Group group3 = new Group();
        group3.name = "Java Core";

        Group[] groups = {group1,group2,group3};
    }

    //Question 9:
    //In ra tất cả các group "Java"
    public static void question9(Group groups) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("In ra tất cả các group \"Java\" là: ");
        Group groups1 = new Group();
        groups1.name = "Java";
        Group groups2 = new Group();
        groups2.name = "Python";
        Group groups3 = new Group();
        groups3.name = "Java Core";

        Group[] group = {groups1,groups2,groups3};

    }
}