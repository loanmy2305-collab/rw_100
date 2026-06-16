package org.example.entity;

public class FresherCandidate extends Candidate{
    private GraduationRank graduationRank;

    public FresherCandidate(){

    }
    public FresherCandidate(int id, String firstName, String lastName, String phone, String email, String password,
                            Role role, GraduationRank graduationRank) {
        super(id, firstName, lastName, phone, email, password, role);
        this.graduationRank = graduationRank;
    }

    public GraduationRank getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(GraduationRank graduationRank) {
        this.graduationRank = graduationRank;
    }
}
