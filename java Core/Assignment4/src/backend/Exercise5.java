package backend;

import java.util.ArrayList;

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
        protected String gender;
        protected String address;

        public CanBo(String name, int age,String gender,String address){
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.address = address;
        }

        public void display(){
            System.out.println("Tên là :" + name);
            System.out.println("Tuổi là :" + age);
            System.out.println("Giới tính là :" + gender);
            System.out.println("Địa chỉ là :" + address);
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
    }


    class QLCB{
        private ArrayList<CanBo>list = new ArrayList<>();


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
