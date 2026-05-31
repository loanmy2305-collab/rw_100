package org.example.dto.context;

import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;

import java.util.List;
import java.util.Map;

public class AccountContext  {
    private Map<String, Account> mapAccountByUsername;
    private Map<String, Account> mapAccountByEmail ;
    private List<Department> departments ;
    private List<Position> positions ;



    public AccountContext(Map<String, Account> mapAccountByUsername, Map<String, Account> mapAccountByEmail, List<Department> departments, List<Position> positions) {
        this.mapAccountByUsername = mapAccountByUsername;
        this.mapAccountByEmail = mapAccountByEmail;
        this.departments = departments;
        this.positions = positions;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public Map<String, Account> getMapAccountByUsername() {
        return mapAccountByUsername;
    }

    public void setMapAccountByUsername(Map<String, Account> mapAccountByUsername) {
        this.mapAccountByUsername = mapAccountByUsername;
    }

    public Map<String, Account> getMapAccountByEmail() {
        return mapAccountByEmail;
    }

    public void setMapAccountByEmail(Map<String, Account> mapAccountByEmail) {
        this.mapAccountByEmail = mapAccountByEmail;
    }
}
