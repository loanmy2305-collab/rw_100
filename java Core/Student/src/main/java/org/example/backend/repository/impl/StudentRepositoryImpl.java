package org.example.backend.repository.impl;

import org.example.backend.repository.IStudentRepository;
import org.example.entity.Student;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {

            connection = JDBCUtils.getConnection();
            String sql ="SELECT s.student_id, s.full_name, s.email, s.date_of_birth, m.major_name AS major_name " +
                    "FROM student s " +
                    "JOIN major m ON s.major_id = m.major_id";
                statement = connection.createStatement();
                rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Student student = new Student(
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getString("email"),
                    rs.getDate("date_of_birth"),
                    rs.getString("major_name")
                    );
                    students.add(student);
                    }


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                JDBCUtils.closeConnection(connection, statement, rs);
            }
            return students;
        }

    @Override
    public boolean checkExistEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean checkExist = false;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select * from student where email = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);
            rs = statement.executeQuery();
            if (rs.next()) {
                checkExist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return checkExist;

    }

    @Override
    public boolean create(String fullName, String email, java.sql.Date birth_date, int major_id) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        Student student = null;
        try {

            connection = JDBCUtils.getConnection();
            String sql = "INSERT INTO student (full_name, email, date_of_birth, major_id) " +
                    "VALUES (?, ?, ?, ?');";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,fullName);
            preparedStatement.setString(2,email);
            preparedStatement.setDate(3,birth_date);
            preparedStatement.setInt(4, major_id);
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);

        }
        return false;
    }

    @Override
    public boolean updateMajorId(int studentId, int majorId) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        Student student = null;
        try {

            connection = JDBCUtils.getConnection();
            String sql = "UPDATE student SET major_id = ? WHERE Id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,studentId);
            preparedStatement.setInt(1,majorId);

            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);

        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        ResultSet rs =  null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "DELETE  FROM Student WHERE student_id = ?;";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            // thực thi câu sql
            int c = statement.executeUpdate();

            return c > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return false;
    }

    @Override
    public List<Student> findByMajorName(String majorName) {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {

            connection = JDBCUtils.getConnection();
            String sql = "SELECT s.student_id, s.full_name, s.email, s.date_of_birth, m.major_name AS major_name " +
                            "FROM student s " +
                            "JOIN major m ON s.major_id = m.major_id " +
                            "WHERE m.major_name = ?";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("email"),
                        rs.getDate("birth_date"),
                        rs.getString("major_name")
                );
                students.add(student);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return students;
    }

}
