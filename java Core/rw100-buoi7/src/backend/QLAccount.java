package backend;

import entity.Account;
import entity.Department;
import entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLAccount {
    public static void showAccount() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "root";

        try {
            //b1 kết nốt Acc
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối Acc thành công");
                }
            //b2:
            String sql = "select * from Account;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Account> accounts = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("account_id");
                String username1 = rs.getString("account_username1");
                String fullName = rs.getString("account_fullName");
                String email = rs.getString("account_email");

                Account acc = new Account(id, username1, fullName, email);
                accounts.add(acc);
            }
            for (Account acc: accounts) {
                System.out.println(acc);
            }
            } catch(Exception e){
                System.out.println("Kết nối Acc ko thành công");

            }
        }


    public static void findByfullName(String searchfullName) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "root";

        try {
            //b1 kết nốt Acc
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối Acc thành công");
            }
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from account where account_fullName = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchfullName);
            ResultSet rs = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("account_id");
                String fullName = rs.getString("account_fullName");
                Account acc = new Account(id, fullName);
                accounts.add(acc);
            }
            for (Account acc: accounts) {
                System.out.println(acc);
            }

        } catch (Exception e) {
            System.out.println("Kết nối Acc ko thành công");
        }
    }


    public static void findByfullNameAndUsername(String searchfullName, String searchusername) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "root";

        try {
            //b1 kết nốt Acc
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối Acc thành công");
            }
            // b2: tìm các phòng ban có tên là name
            String sql = "select * from account where account_fullName like ? and account_username = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, searchfullName);
            statement.setString(2, searchusername);
            ResultSet rs = statement.executeQuery();
            List<Account> accounts = new ArrayList<>();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("account_id");
                String username1 = rs.getString("account_username");
                String fullName = rs.getString("account_fullName");
                Account acc = new Account(id, fullName, username1);
                accounts.add(acc);
            }
            for (Account acc: accounts) {
                System.out.println(acc);
            }

        } catch (Exception e) {
            System.out.println("Kết nối Acc ko thành công");
        }
    }






}

