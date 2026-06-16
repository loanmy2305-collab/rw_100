package org.example.entity;

public class Employee extends User {
    private String proSkill;

    public Employee(String proSkill) {
        this.proSkill = proSkill;
    }



    public Employee(Long id, String fullName, String email, String password, Role role, String proSkill) {
        super(id, fullName, email, password, role);
        this.proSkill = proSkill;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
