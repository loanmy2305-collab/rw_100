package org.example.backend.service.impl;

import org.example.backend.repository.ICandidateRepository;
import org.example.backend.repository.impl.CandidateRepositoryImpl;
import org.example.backend.service.ICandidateService;
import org.example.entity.Candidate;
import org.example.entity.GraduationRank;

import java.sql.SQLException;

public class CandidateServiceImpl implements ICandidateService {
    private ICandidateRepository candidateRepository = new CandidateRepositoryImpl();

    @Override
    public boolean registerExperience(String firstName, String lastName, String phone, String email, String password, int expInYear, String proSkill) throws SQLException, ClassNotFoundException {
        boolean check = candidateRepository.registerExperience(firstName,lastName,phone,email,password,expInYear,proSkill);
        return check;
    }

    @Override
    public boolean registerFresher(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
        boolean check = candidateRepository.registerFresher(firstName,lastName,phone,email,password,graduationRank);
        return check;
    }

    @Override
    public Candidate login(String email, String password) {

        return candidateRepository.login(email, password);
    }

    @Override
    public boolean isUseExistByEmail(String email) {
        return candidateRepository.isUseExistByEmail(email);
    }
}
