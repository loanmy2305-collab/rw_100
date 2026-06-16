package org.example.backend.repository;

import org.example.entity.Candidate;
import org.example.entity.GraduationRank;
import org.example.entity.Role;

import java.sql.SQLException;

public interface ICandidateRepository {
    boolean registerExperience( String firstName, String lastName, String phone, String email, String password,
                                int expInYear, String proSkill) throws SQLException, ClassNotFoundException;
    boolean registerFresher(String firstName, String lastName, String phone, String email, String password,
                             GraduationRank graduationRank);
    Candidate login(String email, String password);
    boolean isUseExistByEmail(String email);

}
