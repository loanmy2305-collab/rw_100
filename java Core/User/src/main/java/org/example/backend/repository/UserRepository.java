package org.example.backend.repository;

import org.example.entity.Admin;
import org.example.entity.Employee;
import org.example.entity.Role;
import org.example.entity.User;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            //b1 kết nốt Acc
            connection = JDBCUtils.getConnection();
            //b2:
            String sql = "SELECT * FROM `user`";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Long id = rs.getLong("id");// lấy giá trị từ cloumn account_id
                String fullName = rs.getString("fullName");//lấy giá trị từ cloumn account_name
                String email = rs.getString("email");
                String password = rs.getString("password");
                Role role = Role.valueOf(rs.getString("Role"));
                if (role == Role.ADMIN) {
                    int expInYear = rs.getInt("expinyear");
                    User admin = new Admin(id, fullName, email, password, role, expInYear);
                    users.add(admin);
                } else if (role == Role.EMPLOYEE) {
                    String proSkill = rs.getString("proskill");
                    User employee = new Employee(id, fullName, email, password, role, proSkill);
                    users.add(employee);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return users;
    }

    @Override
    public User findById(long id) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        ResultSet rs =  null;
        User user = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "SELECT * FROM `user` WHERE id = ?";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {
                String fullName = rs.getString("fullName");//lấy giá trị từ cloumn account_name
                String email = rs.getString("email");
                String password = rs.getString("password");
                Role role = Role.valueOf(rs.getString("Role"));
                if (role == Role.ADMIN) {
                    int expInYear = rs.getInt("expinyear");
                    user = new Admin(id, fullName, email, password, role, expInYear);
                } else if (role == Role.EMPLOYEE) {
                    String proSkill = rs.getString("proskill");
                    user = new Employee(id, fullName, email, password, role, proSkill);
                }
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        }
        return user;
    }

    @Override
    public boolean deleteId(long id) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        ResultSet rs =  null;
        User user = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "delete  from  where id = ?;";

            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            // thực thi câu sql
            int c = statement.executeUpdate();// trả ra sô row thay đổi trong DB
//            if(c>0) {
//                return true;
//            } else {
//                return false;
//            }

            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return false;
    }

    @Override
    public User login(String email, String password) {
        Connection connection =  null;
        PreparedStatement statement =  null;
        User user = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from user where email = ? and password = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1, email.trim());
            statement.setString(2, password.trim());

            System.out.println("Email nhập = [" + email.trim() + "]");
            System.out.println("Password nhập = [" + password.trim() + "]");

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("TÌM THẤY USER");

                Long id = rs.getLong("id");
                String fullName = rs.getString("fullName");
                Role role = Role.valueOf(rs.getString("role").toUpperCase());

                if (role == Role.ADMIN) {
                    int expInYear = rs.getInt("expinyear");
                    user = new Admin(id, fullName, email, password, role, expInYear);
                } else if (role == Role.EMPLOYEE) {
                    String proSkill = rs.getString("proskill");
                    user = new Employee(id, fullName, email, password, role, proSkill);
                }
            } else {
            System.out.println("KHÔNG TÌM THẤY USER");
        }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,statement,null);
        }
        return user;
    }

    @Override
    public boolean create(String fullName, String email) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        User user = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "INSERT INTO users (fullName, email, password, role) " +
                    "VALUES (?, ?, 'A12345', 'EMPLOYEE');";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"fullName");
            preparedStatement.setString(2,"email");
            int c = preparedStatement.executeUpdate();
            return c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);

        }
        return false;

    }
    @Override
    public boolean checkExistEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        boolean checkExist = false;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from users where email = ?";
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
    }



