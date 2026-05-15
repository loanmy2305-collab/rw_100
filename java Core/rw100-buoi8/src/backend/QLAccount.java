package backend;

import entity.Account;
import entity.Department;
import entity.Position;
import enums.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    public static List<Account> findAllAccount() throws ClassNotFoundException, SQLException {
        List<Account> accounts = new ArrayList<>();

        try {
            //b1 kết nốt Acc
            Connection connection = JDBCUtils.getConnection();
            //b2:
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de  on acc.department_id = de.department_id\n" +
                    "left join position po on po.position_id = acc.position_id;\n";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                LocalDate createDate = rs.getDate("create_date").toLocalDate();
                // trả ra 1 đối tượng Date          // chuyển thành LocalDate

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));


                Account acc = new Account(id, userName, fullName, email);
                accounts.add(acc);
            }
            JDBCUtils.closeConnection(connection, statement, rs);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return accounts;
    }


    public static List<Account> findByName(String searchName) {
        List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id " +
                    "where acc.full_name like ? ;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "%" + searchName + "%");

            ResultSet rs = prepareStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                Date createDate = rs.getDate("create_date");

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));

                Account account = new Account(id, userName, fullName, email, department, position, createDate.toLocalDate());
                accounts.add(account);
                JDBCUtils.closeConnection(connection, prepareStatement, rs);
            }
            return accounts;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return accounts;
    }

    public static List<Account> findByIdAndName(String searchfullName, String searchusername) throws ClassNotFoundException, SQLException {

        List<Account> accounts = new ArrayList<>();

        try {
            //b1 kết nốt Acc
            Connection connection = JDBCUtils.getConnection();
            // b2: tìm các phòng ban có tên là name
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id " +
                    "where acc.username like ? and full_name like ? ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchusername + "%");
            statement.setString(2, "%" + searchfullName + "%");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                Integer id = rs.getInt("account_id");// lấy giá trị từ cloumn account_id
                String email = rs.getString("email");//lấy giá trị từ cloumn account_name
                String userName = rs.getString("username");
                String fullName = rs.getString("full_name");
                Integer departmentID = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                Integer positionID = rs.getInt("position_id");
                String positionName = rs.getString("position_name");
                LocalDate createDate = rs.getDate("create_date").toLocalDate();

                Department department = new Department(departmentID, departmentName);
                Position position = new Position(positionID, PositionName.valueOf(positionName));

                Account account = new Account(id, userName, fullName, email, department, position, createDate);
                accounts.add(account);
            }

            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    // thêm mới chức năng

    public static boolean creatAccount(String username, String fullName, String email, int depId, int posId ) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "insert into account (username, full_name ,email, department_Id, position_Id) values ( ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, fullName);
            statement.setString(3, email);
            statement.setInt(4, depId);
            statement.setInt(5, posId);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    // sửa

    public static boolean updateAccount(int id, int updateDepId, int updatePosId) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "update account set department_id = ? , position_id = ? where account_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, updateDepId);
            statement.setInt(3, updatePosId);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    // xóa

    public static boolean deleteAccount(int id) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "delete from account where account_id = ?; ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }






}

