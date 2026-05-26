package org.example.backend.repository.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.entity.Department;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class DepartmentRepositoryImpl implements IDepartmentRepository {
    @Override
    public List<Department> findAll() { // lấy ra ds department
        List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        Connection connection =  null;
        Statement statement =  null;
        ResultSet rs =  null;
        try {
            // b1: kết nối đến DB

            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return departments;
    }

    @Override
    public boolean insert(String name) {
        Connection connection =  null;
        PreparedStatement statement =  null;

        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "insert into department (department_name) values (?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            // thực thi câu sql
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
    public boolean createListDepartment(List<Department> list) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "insert into department (department_name) values (?); ";
            preparedStatement = connection.prepareStatement(sql);
            for (Department department : list){
                preparedStatement.setString(1, department.getName());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();// executeBatch chạy câuleenhjh insert nhiều phần tử
            return true;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, null);

        }
        return false;
    }

    @Override
    public Map<String, Department> mapByName() {
        Connection connection =  null;
        Statement statement =  null;
        ResultSet rs =  null;
        Map<String, Department>mapByName = new HashMap<>(); // lưu lại dữ liệu lấy từ DB

        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department order by department_id asc; ";
            statement = connection.createStatement();

            rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs

            while (rs.next()) {
                int id = rs.getInt("department_id");//lấy ra gtri từ cloumn department_id
                String name = rs.getString("department_name"); //lấy ra gtri từ cloumn department_name
                Department dep = new Department(id, name);
                mapByName.put(name, dep);
            }
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);

        }
        return mapByName;
    }
    @Override
    public boolean delete(int id) {
        Connection connection =  null;
        PreparedStatement statement =  null;

        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: xóa theo thên phòng ban
            String sql = "delete from department\n" +
                    "where department_id like ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            // thực thi câu sql
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
            JDBCUtils.closeConnection(connection, statement, null);

        }
        return false;
    }

    @Override
    public boolean update(int id, String updateName) {
        Connection connection =  null;
        PreparedStatement statement =  null;

        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: xóa theo thên phòng ban
            String sql = "update department set department_name = ? where department_id = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, updateName);
            statement.setInt(2, id);
            // thực thi câu sql
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
            JDBCUtils.closeConnection(connection, statement, null);

        }
        return false;
    }

    @Override
    public boolean checkExistID(Integer id) {
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        ResultSet rs =  null;
        boolean check = false;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_id = ? ";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);

        }
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        boolean check = false;
        Connection connection =  null;
        PreparedStatement preparedStatement =  null;
        ResultSet rs =  null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department where department_name like ? ";
            if (Objects.nonNull(id)) {// check update
                sql += "and department_id != ? ";
            }
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            if (Objects.nonNull(id)) {// check update
                preparedStatement.setInt(2, id);
            }

            rs = preparedStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            JDBCUtils.closeConnection(connection, preparedStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, preparedStatement, rs);

        }
        return check;
    }


}






