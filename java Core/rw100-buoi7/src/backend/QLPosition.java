package backend;

import entity.Account;
import entity.Position;
import enums.PositionName;
import utils.JDBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    public static List<Position> findAllPosition() throws ClassNotFoundException, SQLException {
        List<Position> positions = new ArrayList<>();

        try {
            //b1 kết nốt Pos
            Connection connection = JDBUtils.getConnection();
            //b2:
            String sql = "select * from Position;";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                Position po = new Position(id, positionName);
                positions.add(po);
            }
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
            System.out.println("+-----+--------------------+");
            for (Position po : positions) {
                System.out.printf("|%5s|%20s|\n", po.getId(), po.getName());
            }
            System.out.println("+-----+--------------------+");
        } catch(Exception e){
            e.printStackTrace();

        }
        return positions;
    }


    public static List<Position> findByPositionName(String PositionName) throws ClassNotFoundException, SQLException {

        List<Position> positions = new ArrayList<>();
        try {
            //b1 kết nốt Pos
            Connection connection = JDBUtils.getConnection();

            String sql = "select * from account where position_PositionName = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, PositionName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                // chuyển từ postionname từ string -> enum póitionname
                PositionName positionName = enums.PositionName.valueOf(name);
                Position pos = new Position(id, enums.PositionName.valueOf(name));
                positions.add(pos);
            }
            System.out.println("+-----+--------------------+");
            System.out.printf("|%5s|%20s|\n", "ID", "Tên chức vụ");
            System.out.println("+-----+--------------------+");
            for (Position po : positions) {
                System.out.printf("|%5s|%20s|\n", po.getId(), po.getName());
            }
            System.out.println("+-----+--------------------+");

        } catch (Exception e) {
            // System.out.println("Kết nối Pos ko thành công");
            e.printStackTrace();
        }
        return positions;
    }


}
