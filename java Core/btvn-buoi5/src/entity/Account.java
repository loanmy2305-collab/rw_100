package entity;

import java.time.LocalDate;

public class Account {
    private int id;
    private String email;
    private String username;
    private String fullname;
    private Position position;
    private LocalDate createDate;
    private Department department;

    public Account(){

    }

    public Account(int id, String username, String fullname,Department department, Position position,String email, LocalDate createDate) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.position = position;
        this.createDate = createDate;
        this.email = email;
        this.department = department;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;




    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}


