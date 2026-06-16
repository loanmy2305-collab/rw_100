package org.example.backend.repository.impl;

import org.example.backend.repository.ILecturerRepository;
import org.example.entity.Lecturer;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LecturerRepositoryImpl implements ILecturerRepository {

    @Override
    public Lecturer findById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {

            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM lecturer WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                Lecturer lecturer = new Lecturer();

                lecturer.setId(rs.getInt("id"));
                lecturer.setName(rs.getString("name"));
                lecturer.setEmail(rs.getString("email"));
                return lecturer;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        }

        return null;
    }
}
