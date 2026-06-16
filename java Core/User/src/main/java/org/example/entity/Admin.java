package org.example.entity;

public class Admin extends User{
    public long expInYear;


    public Admin(String fullName, String email, String password, Role role, int expInYear) {
        super(fullName, email, password, role);
        this.expInYear = expInYear;
    }

    public Admin(Long id, String fullName, String email, String password, Role role, int expInYear) {
        super(id, fullName, email, password, role);
        this.expInYear = expInYear;
    }

    public long getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(long expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "expInYear=" + expInYear +
                '}';
    }
}
