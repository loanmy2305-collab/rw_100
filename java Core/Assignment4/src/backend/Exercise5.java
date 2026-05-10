package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5 {
    // Question 1: inheritance
    //Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên. Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ, khác), địa chỉ.
    //
    //Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
    //Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo. Các nhân viên có thuộc tính riêng: công việc.
    //
    //Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp CanBo.
    //
    //Question 2: Tiếp tục Question 1
    //Xây dựng lớp QLCB(quản lý cán bộ) cài đặt các phương thức thực hiện các chức năng sau:
    //Thêm mới cán bộ.
    //Tìm kiếm theo họ tên.
    //Hiện thị thông tin về danh sách các cán bộ.
    //Nhập vào tên của cán bộ và delete cán bộ đó
    //Thoát khỏi chương trình.


    class CanBo{


        protected String name;
        protected int age;
        protected String gioiTinh;
        protected String address;

        public CanBo(String name, int age,String gioiTinhinh,String address){
            this.name = name;
            this.age = age;
            this.gioiTinh = gioiTinh;
            this.address = address;
        }

        public void display(){
            System.out.println("Tên là :" + name);
            System.out.println("Tuổi là :" + age);
            System.out.println("Giới tính là :" + gioiTinh);
            System.out.println("Địa chỉ là :" + address);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gioiTinh;
        }

        public void setGender(String gender) {
            this.gioiTinh = gioiTinh;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    }

        class CongNhan extends CanBo{
        private int bac;

            public CongNhan(String name, int age, String gender, String address, int bac) {
                super(name, age, gender, address); // gọi constructor cha
                this.bac = bac;
            }
            @Override
              public void display(){
                    super.display();
                    System.out.println("Bậc: " + bac);
                }

            public int getBac() {
                return bac;
            }

            public void setBac(int bac) {
                this.bac = bac;
            }
        }

        class KySu extends CanBo{
        private String NghanhDaoTao;

            public KySu(String name, int age, String gender, String address, String NghanhDaoTao){
                super(name, age, gender, address);
                this.NghanhDaoTao = NghanhDaoTao;
            }
            @Override
            public void display(){
                super.display();
                System.out.println("Nghành đào tạo: " + NghanhDaoTao);
            }

            public String getNghanhDaoTao() {
                return NghanhDaoTao;
            }

            public void setNghanhDaoTao(String nghanhDaoTao) {
                NghanhDaoTao = nghanhDaoTao;
            }
        }

    class NhanVien extends CanBo{
        private String CongViec;

        public NhanVien(String name, int age, String gender, String address, String CongViec){
            super(name, age, gender, address);
            this.CongViec = CongViec;
        }
        @Override
        public void display(){
            super.display();
            System.out.println("Công việc là: " + CongViec);
        }

        public String getCongViec() {
            return CongViec;
        }

        public void setCongViec(String congViec) {
            CongViec = congViec;
        }
    }


//    class QLCB{
//        private ArrayList<CanBo>list = new ArrayList<>();


        public static void QLCB(){
            Scanner scanner = new Scanner(System.in);
            List<CanBo> canBos = new ArrayList<>();

            while (true){
                System.out.println("====Mời bạn chọn chức năng =====");
                System.out.println("1.Thêm mới cán bộ ");
                System.out.println("2.tìm kiếm theo họ tên");
                System.out.println("3.hiển thị thông ti về danh sách các cán bọ");
                System.out.println("4.nhâập vào tên của cán bộ và delete cán bộ đó");
                System.out.println("5.thoát khỏi chương trình");
                String choose = scanner.nextLine();
                switch (choose) {
                    case "1":
                        System.out.println("chức năng thêm mới cán bộ");
                        System.out.println(" nhập họ tên: ");
                        String fullname = scanner.nextLine();
                        System.out.println("nhập tuổi");
                        String age = scanner.nextLine();
                        scanner.nextLine();
                        System.out.println("nhập địa chỉ");
                        String diachi = scanner.nextLine();
                        System.out.println("Nhập giới tính: 1. Nam   2. Nữ   Khác. Khác");
                        String gioiTinhChoose = scanner.nextLine();
                       String gioiTinh;
                        switch (gioiTinhChoose){
                            case "1":

                        }


                        break;
                    case "2":
                        System.out.println("chức năng tìm kiếm họ tên");
                        System.out.println("Nhập tên cần tìm");
                        String name = scanner.nextLine();
                        System.out.println("======================");
                        boolean checkExists = false;
                        for (CanBo canBo : canBos) {
                            if (canBo.getName().equals(name)) {
                                System.out.println(canBo);
                                checkExists = true;
                            }
                        }

//                    canBos.stream().filter( i -> i.getFullName().equals(name));
//                    System.out.println(canBos);

                        if (!checkExists) { //checkExists == false
                            System.out.println("Tên này ko có trong hệ thống!!");
                        }
                        System.out.println("======================");
                        break;
                    case "3":
                        System.out.println("Chức năng Hiện thị thông tin về danh sách các cán bộ.");
                        for (CanBo cb: canBos) {
                            System.out.println(cb.toString());
                        }
                        System.out.println("======================");
                        break;

                    case "4":
                        System.out.println("Chức năng Nhập vào tên của cán bộ và delete cán bộ đó.");
                        System.out.println("Nhập tên cần xóa");
                        String deleteName = scanner.nextLine();

                        // xóa cán bộ có tên vừa nhập ra khỏi ds
                        List<CanBo> deletes = new ArrayList<>();// ds các cán bộ sẽ bị xóa
                        for (CanBo canBo : canBos) {
                            if (canBo.getName().equals(deleteName)) {
                                deletes.add(canBo);
                            }
                        }// sau khi chạy xong for thì sẽ có ds cần xóa
                        // xóa ds đi
                        boolean checkDelete = canBos.removeAll(deletes);

//                    canBos.removeIf(i -> i.getFullName().equals(deleteName));
                        if (checkDelete) {//checkDelete == true
                            System.out.println("Xóa thành công!!");
                        } else {
                            System.out.println("Tên này không tồn tại trong hệ thống!!");
                        }
                        System.out.println("======================");

                        break;
                    case "5":
                        System.out.println("nhâập vào tên của cán bộ và delete cán bộ đó");
                        break;
                    default:
                        System.out.println();


                }

            }
        }






    //Question 3 (Optional): constructor inheritance
    //Tạo class abstract Person gồm các property name và tạo constructor có 1 parameter name
    //Tạo class abstract Student kế thừa Person gồm các property id, name và tạo constructor có 2 parameter id, name
    //Tạo class HighSchoolStudent kế thừa Student bao gồm các property id, name, clazz (Lớp đang học), desiredUniversity (trường đại học mong muốn vào) và tạo constructor có 4 parameter id, name, clazz, desiredUniversity.
    //
    //Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name = "Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công nghệ"
    //
    //Question 4 (Optional):
    //Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất), Tên nhà xuất bản, số bản phát hành.
    //
    //Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
    //Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành. Các báo cần quản lý thêm: Ngày phát hành.
    //
    //Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một cách hiệu quả.
    //Xây dựng lớp QuanLySach có các chức năng sau
    //Thêm mới tài liêu: Sách, tạp chí, báo.
    //Xoá tài liệu theo mã tài liệu.
    //Hiện thị thông tin về tài liệu.
    //Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
    //Thoát khỏi chương trình.
}
