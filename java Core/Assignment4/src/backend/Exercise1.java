package backend;

import entity.Account;
import entity.Department;
import entity.Group;

import java.util.Date;

public class Exercise1 {
//    Question 1:
//    Tạo constructor cho department:
//    không có parameters(tham số)
//    Có 1 parameter là nameDepartment và default id của entity.Department = 0
//    Khởi tạo 1 Object với mỗi constructor ở trên

    public static void main(String[] args){
        Department department = new Department();
        Department department1 = new Department("Sale");

        System.out.println(department);
        System.out.println(department1);

    }
//
//    Question 2:
//    Tạo constructor cho entity.Account:
//    Không có parameters
//    Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName)
//    Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và
//    entity.Position của User, default createDate = now
//    Có các parameter là id, Email, Username, FirstName, LastName (với FullName = FirstName + LastName) và entity.Position của User, createDate
//    Khởi tạo 1 Object với mỗi constructor ở trên

    public static void question2(){
        Account account = new Account();
        Account account1 = new Account(1,"account1@gmail.com.vn" , "account1","Hoang","Loan" );
        Account account2 = new Account(2,"account2@gmail.com.vn" , "account2","Tra","My" ,"TEST");
        Account account3 = new Account(3,"account3@gmail.com.vn" , "account3","Gia","Huy","DEV", new Date());

        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);

    }
// Question 3
//    Tạo constructor cho entity.Group:
//    không có parameters
//    Có các parameter là GroupName, Creator, array entity.Account[] accounts, CreateDate
//    Có các parameter là GroupName, Creator, array String[] usernames , CreateDate
//    Với mỗi username thì sẽ khởi tạo 1 entity.Account (chỉ có thông tin username, các thông tin còn lại = null). Khởi tạo 1 Object với mỗi constructor ở trên

    Account[] accounts = {new Account()} ;
    public static void question3(){
        Group group = new Group();
        Group group1 = new Group();
        Group group2 = new Group();

    }

}
