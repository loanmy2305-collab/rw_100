package backend;

import entity.Account;
import entity.Position;
import enums.PositionName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    public static void showPosition() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "root";

        try {
            //b1 kết nốt Pos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối Pos thành công");
            }
            //b2:
            String sql = "select * from Position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            List<Position> positions = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                Position pos = new Position(id, PositionName.DEV);
                positions.add(pos);
            }
            for (Position pos: positions) {
                System.out.println(pos);
            }
        } catch(Exception e){
            System.out.println("Kết nối Pos ko thành công");

        }
    }


    public static void findByPositionName(String PositionName) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/rw100_testing_system";
        String username = "root";
        String password = "root";

        try {
            //b1 kết nốt Pos
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                System.out.println("Kết nối Pos thành công");
            }

            String sql = "select * from account where position_PositionName = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, PositionName);
            ResultSet rs = statement.executeQuery();
            List<Position> positions = new ArrayList<>();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                Position pos = new Position(id, enums.PositionName.PM);
                positions.add(pos);
            }
            for (Position pos: positions) {
                System.out.println(pos);
            }

        } catch (Exception e) {
            System.out.println("Kết nối Pos ko thành công");
        }
    }


}
