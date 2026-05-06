package backend;
public  class Exercise4 {
}

    //Tạo Object Student có các property(tài sản) id, name, hometown, điểm học lực
    //Tất cả các property sẽ để là private để các class khác không chỉnh sửa hay nhìn thấy
    //Tạo constructor cho phép khi khởi tạo mỗi student thì người dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
    //Tạo 1 method cho phép set điểm vào
    //Tạo 1 method cho phép cộng thêm điểm
    //Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên, điểm học lực
        // ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm > 4.0 và < 6.0 thì sẽ in ra là trung bình,
        // nếu điểm > 6.0 và < 8.0 thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi) Demo các chức năng trên bằng class ở front-end.
    class  Student {

    private int id;
    private String name;
    private String hometown;
    private float score;

    public Student(String name,String hometown,float score){
        this.name = name;
        this.hometown = hometown;
        this.score = 0;
    }

    public void setScore(float score){
        this.score = score;
    }

    public void addScore(float Extra ){
        this.score = Extra;
    }

    public String getRack() {
        if (score < 4.0) {
            return "Yếu";
        } else if (score < 6.0) {
            return "Trung bình";
        } else if (score < 8.0) {
            return "khá";
        } else  {
            return "Giỏi";
        }
    }

    public void printInfo(){
        System.out.println("tên là: " + name);
        System.out.println("que quán là: " + hometown);
        System.out.println("điểm là: " + score);
        System.out.println("học lực là: " + getRack());
    }





}


