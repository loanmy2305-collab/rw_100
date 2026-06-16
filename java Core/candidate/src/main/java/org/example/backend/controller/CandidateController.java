package org.example.backend.controller;

import org.example.backend.service.ICandidateService;
import org.example.backend.service.impl.CandidateServiceImpl;
import org.example.entity.Candidate;
import org.example.entity.GraduationRank;

import java.sql.SQLException;

public class CandidateController {
    private ICandidateService candidateService = new CandidateServiceImpl();


    public boolean registerExperience(String firstName, String lastName, String phone, String email, String password, int expInYear, String proSkill) throws SQLException, ClassNotFoundException {
        boolean check = candidateService.registerExperience(firstName,lastName,phone,email,password,expInYear,proSkill);
        return check;
    }


    public boolean registerFresher(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
        boolean check = candidateService.registerFresher(firstName,lastName,phone,email,password,graduationRank);
        return check;
    }


    public Candidate login(String email, String password) {
        return candidateService.login(email, password);
    }

    public boolean isUseExistByEmail(String email) {
        return candidateService.isUseExistByEmail(email);
    }

}

