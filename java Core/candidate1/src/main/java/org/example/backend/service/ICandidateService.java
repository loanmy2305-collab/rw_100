package org.example.backend.service;

import org.example.entity.Candidate;
import org.example.entity.GraduationRank;

import java.sql.SQLException;

public interface ICandidateService {
    boolean registerExperience( String firstName, String lastName, String phone, String email, String password,
                                int expInYear, String proSkill) throws SQLException, ClassNotFoundException;
    boolean registerFresher(String firstName, String lastName, String phone, String email, String password,
                            GraduationRank graduationRank);
    Candidate login(String email, String password);
    boolean isUseExistByEmail(String email);
}
