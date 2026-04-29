import java.time.LocalDate;
import java.util.List;

public class Exercise1 {
    public static void main(String[] args) {

        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Marketing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "Bảo vệ";

        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = Position.PositionName.PM;


        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = Position.PositionName.DEV;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = Position.PositionName.TEST;

        Group Group1 = new Group();
        Group1.id = 1;
        Group1.name = "My";

        Group1.createDate = LocalDate.now();

        Group Group2 = new Group();
        Group2.id = 2;
        Group2.name = "An";
        Group2.createDate = LocalDate.now();
        Group[] groups = {Group1, Group2};
        Account acc1 = new Account();
        acc1.id = 1;
        acc1.username = "Loan";
        acc1.fullname = "Nguyen Thi Loan";
        acc1.email = "loanmy2305@gmail.com";
        acc1.position = pos1;
        acc1.department = dep1;
        acc1.createDate = LocalDate.of(2026, 5, 23);
        acc1.groups = groups;
        Account acc2 = new Account();
        acc2.id = 2;
        acc2.username = "My";
        acc2.fullname = "Nguyen Thi Tra My";
        acc2.email = "loanmy2305@gmail.com";
        acc2.position = pos1;
        acc2.department = dep1;
        acc2.createDate = LocalDate.of(2017, 7, 07);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.username = "Huy";
        acc3.fullname = "Nguyen Gia Huy";
        acc3.email = "loanmy2305@gmail.com";
        acc3.position = pos1;
        acc3.department = dep1;
        acc3.createDate = LocalDate.of(2020, 2, 19);
        question1(acc2);
        question2(acc1);
        question3(acc2);
        question4(acc1);
        question5(acc1);
        question6(acc1);
        question7(acc1);
        question8(acc1);
        question9(dep1);
        question10(acc1, Group1);



    }

    public static void question1(Account account) {
        // Question 1:
        // Kiểm tra account thứ 2
        // Nếu không có phòng ban (tức là department == null) thì sẽ in ra txt
        // "Nhân viên này chưa có phòng ban"
        // Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"

        if (account.department == null) {
            System.out.println("Nhân viên này chưa có phòng ban");

        } else {
            System.out.println("Phòng ban của nhân viên này là " + account.department.name);
        }
    }

    // Question 2:Kiểm tra account thứ 2
    //Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
    //Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
    //Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
    //Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"}

    public static void question2(Account account) {

        int count = 0;
        if (account.groups.length == 0)
            System.out.println("Nhân viên này chưa có group");
        else if (account.groups.length == 1 || account.groups.length == 2)
            System.out.println("Group của nhận viên này là Java Fresher, C# Fresher");
        else if (account.groups.length == 3)
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        else
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
    }


    // 3.Sử dụng toán tử ternary để làm Question 1
    public static void question3(Account account) {
        String result = (account.department == null) ?
                "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là "
                + account.department.name;
        System.out.println(result);
    }
    // Question 4: Sử dụng toán tử ternary để làm yêu cầu sau:
    // Kiểm tra Position của account thứ 1
    // Nếu Position = Dev thì in ra text "Đây là Developer"
    // Nếu không phải thì in ra text "Người này không phải là Developer"

    public static void question4(Account account) {
        String result = (account.position.name == Position.PositionName.DEV) ?
                "Đây là Developer" : "Người này không phải là Developer";
        System.out.println(result);
    }


    //Question 5:
    //Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
    //Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
    //Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
    //Còn lại in ra "Nhóm có nhiều thành viên"

    public static void question5(Account account) {
        switch (account.groups.length) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }
    }
//Question 6: Sử dụng switch case để làm lại Question 2

    public static void question6(Account account) {

        switch (account.groups.length) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhận viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");

        }

    }

    // 7.Sử dụng switch case để làm lại Question 4
    public static void question7(Account account) {
        String positionName = account.position.name.toString();
        switch (positionName) {
            case "DEV":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }
    }
// 8.In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ

    public static void question8(Account account) {
        String depName = (account.department == null) ? "Chưa có phòng ban" : account.department.name;
        System.out.println("Email: " + account.email + " | FullName: " + account.fullname + " | Phòng ban: " + depName);
    }


    // 9. In ra thông tin các phòng ban bao gồm: id và name
    public static void question9(Department department) {
        System.out.println("ID: " + department.id);
        System.out.println("Name: " + department.name);
    }

    // Question 10:
    //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
    //Thông tin account thứ 1 là:
    //Email: NguyenVanA@gmail.com
    //Full name: Nguyễn Văn A
    //Phòng ban: Sale
    //
    //Thông tin account thứ 2 là:
    //Email: NguyenVanB@gmail.com
    //Full name: Nguyễn Văn B
    //Phòng ban: Marketting
    public static void question10(Account account, Group group) {
        for (int i = 0; i < account.groups.length; i++) {
            System.out.println("Thong tin account thu: " + (i + 1));
            System.out.println("Email: " + account.email);
            System.out.println("Fullname: " + account.fullname);
            System.out.println("phong ban: " + account.department);
        }
    }

    // Question 11:
    //In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
    //Thông tin department thứ 1 là:
    //	 	 	Id: 1
    //	 	 	Name: Sale
    //Thông tin department thứ 2 là:
    //	 	 	Id: 2
    //	 	 	Name: Marketing
    public static void question11(Department[] departments) {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thong tin department:" + (i + 1));
            System.out.println("id:" + departments[i].id);
            System.out.println("name:" + departments[i].name);
        }
    }

    // Question 12:Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
    public static void question12(Department[] departments) {
        for (int i = 0; i < departments.length;i++){
            if (i  == 2) break;
            System.out.println("id la:" + departments[i].id);
            System.out.println("name la:" + departments[i].name);
        }
    }

    // Question 13:In ra thông tin tất cả các account ngoại trừ account thứ 2
    public static void question13(Account account) {
        for (int i = 0; i < account.accounts.length; i++) {
            if (i == 1) {
                continue;
            }
            System.out.println("Thông tin account các thứ " + (i + 1));
            System.out.println("email là :" + account.email);
            System.out.println("fullname là :" + account.fullname);
            System.out.println("phòng ban là :" + account.department);
        }
    }

    //Question14: In ra thông tin tất cả các account có id < 4
    public static void question14(Account account) {
        for (int i = 0; i < account.accounts.length; i++) {
            if (account.id < 4) {
                System.out.println("email là :" + account.email);
                System.out.println("fullname là :" + account.fullname);
                System.out.println("phòng ban là :" + account.department);
            }
        }
    }

    // Question15 : In ra các số chẵn nhỏ hơn hoặc bằng 20
    public static void question15(Account account) {
        for (int i = 2; i <= 20; i++) {
            System.out.println(i);
        }
    }

    // Question16:Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
    public static void question16(Account account, Department[] departments) {
        // question10:
        int i = 0;
        while (i < account.groups.length) {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("Email: " + account.email);
            System.out.println("Fullname: " + account.fullname);
            System.out.println("phong ban: " + account.department);
            i++;
        }
        // question11:
        int i1 =0;
        while (i < departments.length) {
            System.out.println("Thong tin department:" + (i + 1));
            System.out.println("id:" + departments[i].id);
            System.out.println("name:" + departments[i].name);
            i++;
        }
        // question12:
        int i2 = 0;
        while (i < departments.length) {
            if (i == 2)
                break;
            System.out.println("id la:" + departments[i].id);
            System.out.println("name la:" + departments[i].name);
        }
        // question13
        int i3 = 0;
        while (i < account.accounts.length) {
            if (i == 1) continue;
            System.out.println("Thông tin account các thứ " + (i + 1));
            System.out.println("email là :" + account.email);
            System.out.println("fullname là :" + account.fullname);
            System.out.println("phòng ban là :" + account.department);
        }

        // question14
        int i4 = 0;
        while (i < account.accounts.length) {
            System.out.println("email là :" + account.email);
            System.out.println("fullname là :" + account.fullname);
            System.out.println("phòng ban là :" + account.department);
            i++;
        }
    }
    // Question 17:Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue
    public static void question17(Account[] accounts, Department[] departments) {

        // question10
        int i = 0;
        if (accounts.length == 0) return;
        do {
            System.out.println("Thông tin account thứ " + (i + 1));
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Fullname: " + accounts[i].fullname);
            System.out.println("phong ban: " + accounts[i].department);
            i++;
        }
        while (i < accounts.length);
        // question11
        int i1 = 0;
        if (departments.length == 0) return;
        do {
            System.out.println("Thong tin department:" + (i + 1));
            System.out.println("id:" + departments[i].id);
            System.out.println("name:" + departments[i].name);
            i++;
        }
        while (i < departments.length);

        // question12
        int i2 =0;
        if (accounts.length == 0) return;
        do {
            if (i == 2) break;
            System.out.println("id la:" + departments[i].id);
            System.out.println("name la:" + departments[i].name);
            i++;
        }
        while (i < accounts.length);

        // question13
        int i3 = 0;
        if (accounts.length == 0) return;
        do {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email là : " + accounts[i].email);
            System.out.println("FullName là: " + accounts[i].fullname);
            i++;
        }
        while (i < accounts.length);

        // question14
        int i4 = 0;
        if (accounts.length == 0) return;
        do {
            System.out.println("email là :" + accounts[i].email);
            System.out.println("fullname là :" + accounts[i].fullname);
            System.out.println("phòng ban là :" + accounts[i].department);
            i++;
        }
        while (i < accounts.length);
    }
}






