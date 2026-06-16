package org.example.backend.repository.impl;

import org.example.backend.repository.ICandidateRepository;
import org.example.entity.*;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CandidateRepositoryImpl implements ICandidateRepository {

    private JDBCUtils jdbcUtils;

    public CandidateRepositoryImpl() {
        jdbcUtils = new JDBCUtils();
    }


}
