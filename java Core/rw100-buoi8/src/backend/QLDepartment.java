package backend;


import entity.Department;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QLDepartment {

    // lấy ds các phòng ban trong DB và in ra
    public static List<Department> findAllDepartment() throws ClassNotFoundException {
        List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB

            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from department;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }


    // tìm các phòng ban có chữ xyz  chưa biết trước
    //  select * from department where department_name like '...';

    public static List<Department> findByNameAndId(String searchName, int searchId) throws ClassNotFoundException{
        List<Department> departments = new ArrayList<>();// lưu lại dữ liệu lấy từ DB

        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();

            // b2: tìm các phòng ban có tên là name
            String sql = "select * from department where department_name like ? and department_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchName);// truyền giá trị searchName vào ? đầu tiên
            statement.setInt(2, searchId);// truyền giá trị 2 vào ? thứ2
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("department_id");// lấy giá trị từ cloumn department_id
                String name = rs.getString("department_name");//lấy giá trị từ cloumn department_name
                Department dep = new Department(id, name);
                departments.add(dep);
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }


    // 1 method in ra phòng ban có >= 2 nhân viên


    public static List<Department> departmentHave2Employee() throws ClassNotFoundException{


        List<Department> departments = new ArrayList<>();
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2:in ra phòng ban có id >=2 nhân viên
            String sql = "select d.*, count(a.accountID) as soluong\n" +
                    "from Departmnet d\n" +
                    "join Account a on a.departmentID = d.departmentID\n" +
                    "group by d.departmentID,d.departmentName\n" +
                    "having count(a.accountID) >= 2;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("department_id");
                String name = rs.getString("department_name");
                Department dep = new Department(id, name);
                departments.add(dep);
            }

            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departments;
    }

    // tạo phòng ban với tên phòng ban đưa từ ngoài vào
    public static boolean creatDepartment(String name) throws ClassNotFoundException{
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "insert into department (department_name) values (?)";
            PreparedStatement statement = connection.prepareStatement(sql);
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
        }
        return false;
    }


    // nhập vào tên phòng ban ,xóa phòng ban dđoó đi


        public static boolean deleteDepartment(String deleteName) throws ClassNotFoundException{

        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: xóa theo thên phòng ban
            String sql = "delete from department\n" +
                    "where department_Name like ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, deleteName);
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
        }
        return false;
    }

    // update phòng ban có id = 1 -> tên phòng ban thành 'abc'


    public static boolean updateDepartment(int id, String updateName) throws ClassNotFoundException{

        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: xóa theo thên phòng ban
            String sql = "update department set department_name = ? where department_id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
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
        }
        return false;
    }

}
