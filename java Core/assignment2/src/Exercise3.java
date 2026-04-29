import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Exercise3 {
    // Question 1:
    //In ra thông tin Exam thứ 1 và property create date sẽ được format theo định dạng vietnamese
    public void question1(Exam exam){
        Locale locale = new Locale("vn", "VN");
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate = simpleDateFormat.format(exam.createDate);
        System.out.println("id là: " + exam.id);
        System.out.println("title là: " + exam.title);
        System.out.println("code là: " + exam.code);
        System.out.println("createDate là: " + formattedDate);
    }

    // Question 2:In ra thông tin: Exam đã tạo ngày nào theo định dạng
    //Năm – tháng – ngày – giờ – phút – giây
    public void question2(Exam exam) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(exam.createDate);
        System.out.println("Exam đã tạo ngày là: " + formatted);
    }

    //Question 3:
    //Chỉ in ra năm của create date property trong Question 2
    public void question3(Exam exam){
        String pattern = "yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(exam.createDate);
        System.out.println("Năm tạo là: " + formatted);
    }

    //Question 4:
    //Chỉ in ra tháng và năm của create date property trong Question 2

    public void question4(Exam exam){
        String pattern = "yyyy-MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(exam.createDate);
        System.out.println("Tháng và năm tạo là: " + formatted);
    }

    //Question 5:Chỉ in ra "MM-DD" của create date trong Question 2

    public void question5(Exam exam){
        String pattern = "MM-DD";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(exam.createDate);
        System.out.println("Tháng và nga tạo là: " + formatted);
    }
}
