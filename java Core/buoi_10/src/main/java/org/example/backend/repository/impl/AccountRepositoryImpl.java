package org.example.backend.repository.impl;

import org.example.backend.repository.IAccountRepository;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Position;
import org.example.enums.PositionName;
import org.example.utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements IAccountRepository {

    @Override
    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        try {
            //b1 kết nốt Acc
           connection = JDBCUtils.getConnection();
            //b2:
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de  on acc.department_id = de.department_id\n" +
                    "left join position po on po.position_id = acc.position_id;\n";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
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

        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return accounts;
    }

    @Override
    public boolean insert(String username, String fullName, String email, int depId, int posId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
             connection = JDBCUtils.getConnection();

            String sql = "insert into account (username, full_name ,email, department_Id, position_Id) values ( ?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, fullName);
            statement.setString(3, email);
            statement.setInt(4, depId);
            statement.setInt(5, posId);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from account where account_id = ?; ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;

    }

    @Override
    public boolean update(int id, int updateDepId, int updatePosId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update account set department_id = ? , position_id = ? where account_id = ? ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, updateDepId);
            statement.setInt(3, updatePosId);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;

    }


    @Override
    public List<Account> findByIdAndName(String searchfullName, String searchusername) {
        List<Account> accounts = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

        try {
            //b1 kết nốt Acc
            connection = JDBCUtils.getConnection();
            // b2: tìm các phòng ban có tên là name
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id " +
                    "where acc.username like ? and full_name like ? ;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchusername + "%");
            statement.setString(2, "%" + searchfullName + "%");
            rs = statement.executeQuery();
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
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return accounts;
    }

    @Override
    public List<Account> findByName(String name) {
        List<Account> accounts = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        ResultSet rs = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id " +
                    "where acc.full_name like ? ;";
            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setString(1, "%" + name + "%");

            rs = prepareStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
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
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, prepareStatement, null);
        }
        return accounts;
    }

    @Override
    public Map<String, Account> mapAccountByUsername() {
        //  key ,  value    key ko được trùng lặp
        Map<String, Account> mapByUsername = new HashMap<>();// lưu lại dữ liệu lấy từ DB
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select acc.*, de.department_name, po.position_name \n" +
                    "from account acc\n" +
                    "left join department de on acc.department_id = de.department_id\n" +
                    "left join position po on acc.position_id = po.position_id;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
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
                mapByUsername.put(userName, account);
            }
        } catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
            e.printStackTrace();
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return mapByUsername;
    }

    @Override
    public boolean checkUsernameExist(String username, Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;

            boolean checkUsernameExist = false;
            try {
                // b1: kết nối đến DB
                 connection = JDBCUtils.getConnection();
                // b2: lấy dữ liệu từ bảng account
//            String sql = "select * from account where username like ?";
//            if (Objects.nonNull(id)) {
//                sql += " and account_id != ?;";
//            }
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, username);
                //if (Objects.nonNull(id)) {
//                statement.setInt(2, id);
//            }

                String sql =  "select * from account where username like ? and (account_id != ? or ? is null);";
                statement = connection.prepareStatement(sql);
                statement.setString(1, username);
                statement.setInt(2, id);
                statement.setInt(3, id);

                rs = statement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
                if (rs.next()) {// lặp qua qua từng dòng của rs
                    checkUsernameExist = true;
                }
                JDBCUtils.closeConnection(connection, statement, rs);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // đóng kết ối
                JDBCUtils.closeConnection(connection, statement, rs);
            }
            return checkUsernameExist;
        }



    @Override
    public boolean checkEmailExist(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs =  null;
        boolean checkEmailExist = false;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select * from account where email like ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, email);

            rs = statement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                checkEmailExist = true;
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return checkEmailExist;
    }

    @Override
    public boolean checkIdExist(Integer id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs =  null;
        boolean checkIdExist = false;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng account
            String sql = "select * from account where account_id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            rs = statement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                checkIdExist = true;
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        // đóng kết ối
        JDBCUtils.closeConnection(connection, statement, rs);
    }
        return checkIdExist;
    }

    @Override
    public boolean update(int id, String updateName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: tiến hành update account
            String sql = "update account set username = ? where account_id = ?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updateName);
            preparedStatement.setInt(2, id);

            int c = preparedStatement.executeUpdate();// executeUpdate sẽ trả về 1 số nguyên, đại diện cho số dòng bị thay đổi trong DB
            return  c > 0;
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }finally {
            // đóng kết ối
            JDBCUtils.closeConnection(connection,preparedStatement, null);

        }
        return false;
    }


  //  @Override
//    public boolean checkUsernameExist(String username) {
//        boolean checkUsernameExist = false;
//        try {
//            // b1: kết nối đến DB
//            Connection connection = JDBCUtils.getConnection();
//            // b2: lấy dữ liệu từ bảng account
//            String sql = "select * from account where username like ?";
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setString(1, username);
//
//            ResultSet rs = statement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
//            if (rs.next()) {// lặp qua qua từng dòng của rs
//                checkUsernameExist = true;
//            }
//            JDBCUtils.closeConnection(connection, statement, rs);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return checkUsernameExist;
//    }
}












