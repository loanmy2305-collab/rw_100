package org.example.backend.repository.impl;

import org.example.backend.repository.ICandidateRepository;
import org.example.entity.*;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRepositoryImpl implements ICandidateRepository {

    private JDBCUtils jdbcUtils;

    public CandidateRepositoryImpl() {
        jdbcUtils = new JDBCUtils();
    }

    @Override
    public boolean registerExperience(String firstName, String lastName, String phone, String email, String password, int expInYear, String proSkill)  {

        Connection connection =  null;
        PreparedStatement statement =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "INSERT INTO `candidate` ( `fisrtname`, `lastname`, `phone`, `email`, `password`, `exp_in_year`, `pro_skill`, `role`) \n" +
                    "VALUES (?,?,?,?,?,?,?, 'ExperienceCandidate');";

            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setInt(6, expInYear);
            statement.setString(7, proSkill);

            // Step 3: Execute SQL query
            int c = statement.executeUpdate();// trả ra sô row thay đổi trong DB
//            if(c>0) {
//                return true;
//            } else {
//                return false;
//            }

            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,statement,null);
        }
        return false;
    }

    @Override
    public boolean registerFresher(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "INSERT INTO `candidate` ( `fisrtname`, `lastname`, `phone`, `email`, `password`, `graduationRank`, `role`) \n" +
                    "VALUES (?,?,?,?,?,?, 'FresherCandidate');";

            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setString(6, String.valueOf(graduationRank));

            // Step 3: Execute SQL query
            int c = statement.executeUpdate();// trả ra sô row thay đổi trong DB
//            if(c>0) {
//                return true;
//            } else {
//                return false;
//            }

            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,statement,null);
        }
        return false;
    }

    @Override
    public Candidate login(String email, String password) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from candidate where email = ? and `password` = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);

            // Step 3: Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handling Result Set
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String phone = resultSet.getString(4);

                String roleString = resultSet.getString(10);// string
                // chuyen tu string về enum
                Role role = Role.valueOf(roleString);

                if (Role.EXPERIENCECANDIDATE.equals(role)) {
                    int expInYear = resultSet.getInt(7);
                    String proSkill = resultSet.getString(8);

                    Candidate e = new ExperienceCandidate(id, firstName, lastName, phone, email, password, role,
                            expInYear, proSkill);
                    return e;
                } else {
                    // chuyển rank từ String >>> enum
                    String g = resultSet.getString(9);
                    GraduationRank graduationRank = GraduationRank.valueOf(g);

                    Candidate f = new FresherCandidate(id, firstName, lastName, phone, email, password, role,
                            graduationRank);
                    return f;
                }
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,statement,null);
        }
        return null;
    }

    @Override
    public boolean isUseExistByEmail(String email) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "SELECT * FROM candidate WHERE Email = ? ";

            statement = connection.prepareStatement(sql);
            statement.setString(1, email);


            // Step 3: Execute SQL query
            ResultSet resultSet = statement.executeQuery();

            // Step 4: Handling Result Set
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,statement,null);
        }

        return false;
    }
}
