package org.example.utils;

import java.sql.*;

public class JDBCUtils {
    public static Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/Student_Management";
        String username = "root";
        String password = "root";// mk mysql

        try {
            // b1: kết nối đến DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
//                if (connection != null) {
//                    System.out.println("Kết nối DB thành công");
//                }
            return connection;
        }catch (Exception e) {
            System.out.println("Kết nối DB ko thành công");
        }
        return null;
    }
    //close cho 3 interface connection, statement, rs
    public static void closeConnection(Connection connection, Statement statement, ResultSet rs)  {
        // ếu cái nào có sưz liệu (đang mở) != null
        try {

            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

