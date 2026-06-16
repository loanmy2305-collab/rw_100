package org.example.entity;


import java.sql.Date;

public class Student {
    private int id;
    private String fullName;
    private String email;
    private Date birthDate;
    private int majorId;
    private String majorName;

    public Student(){}

    public Student(String fullName, String email, Date birthDate, int majorId) {
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.majorId = majorId;
    }

    public Student(int id, String fullName, String email, Date birthDate, String majorName) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
        this.majorName = majorName;


    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", majorId=" + majorId +
                '}';
    }
}
