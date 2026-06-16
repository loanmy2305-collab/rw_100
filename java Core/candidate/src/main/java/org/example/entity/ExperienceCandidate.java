package org.example.entity;

public class ExperienceCandidate extends Candidate {
    private int explnYear;
    private String proSkill;



    public ExperienceCandidate(int id, String firstName, String lastName, String phone, String email, String password,
                               Role role, int expInYear, String proSkill) {
        super(id, firstName, lastName, phone, email, password, role);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    public int getExplnYear() {
        return explnYear;
    }

    public void setExplnYear(int explnYear) {
        this.explnYear = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}
