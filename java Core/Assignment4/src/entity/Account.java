package entity;

import java.util.Date;

public class Account {
    private int accountID;
    private String username;
    private String email;
    private String fullname;
    private String FirstName;
    private String LastName;
    private String Position ;
    private Department department;
    private Date createDate;

    public Account(){
    }

    public Account(int accountID,String email,String username,String FirstName, String LastName){
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.fullname = FirstName + " " + LastName;
    }

    public Account(int accountID,String email,String username,String FirstName, String LastName,String Position){
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.fullname = FirstName + " " + LastName;
        this.Position = Position;
        this.createDate = new Date();
    }

    public Account(int accountID,String email,String username,String FirstName, String LastName,String Position,Date createDate){
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.fullname = FirstName + " " + LastName;
        this.Position = Position;
        this.createDate = createDate ;
    }




}

