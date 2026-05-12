package backend;

import entity.Position;
import enums.PositionName;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QLPosition {
    public static List<Position> findAllPosition() throws ClassNotFoundException, SQLException {
        List<Position> positions = new ArrayList<>();

        try {
            //b1 kết nốt Pos
            Connection connection = JDBCUtils.getConnection();
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
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch(Exception e){
            e.printStackTrace();

        }
        return positions;
    }


    public static List<Position> findByPositionName(String PositionName) throws ClassNotFoundException, SQLException {

        List<Position> positions = new ArrayList<>();
        try {
            //b1 kết nốt Pos
            Connection connection = JDBCUtils.getConnection();

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
            JDBCUtils.closeConnection(connection, statement, rs);


        } catch (Exception e) {
            // System.out.println("Kết nối Pos ko thành công");
            e.printStackTrace();
        }
        return positions;
    }

    //thêm

    public static boolean creatPosition(String name) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "insert into position (position_name) values (?); ";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    // sửa

    public static boolean updatePosition(int id, String updatename) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "update position set position_name = ? where position_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, updatename);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    // xóa

    public static boolean deletePosition(int id) throws ClassNotFoundException {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "delete from position where account_id = ?;\n";
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
