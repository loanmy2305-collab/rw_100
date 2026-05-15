package org.example.backend.repository.impl;

import org.example.backend.repository.IDepartmentRepository;
import org.example.backend.repository.IPositionRepository;
import org.example.entity.Position;
import org.example.enums.PositionName;
import org.example.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
    public List<Position> findAll() {
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

    @Override
    public boolean insert(String name) {
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

    @Override
    public boolean deletePosition(int id) {
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

    @Override
    public boolean updatePosition(int id, String updateName) {
        try {
            Connection connection = JDBCUtils.getConnection();

            String sql = "update position set position_name = ? where position_id = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, updateName);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null );
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

    @Override
    public List<Position> findByName(String searchName) {
        List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        try {
            // b1: kết nối đến DB
            Connection connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position where position_name like ?;";
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setString(1, searchName);

            ResultSet rs = prepareStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs

            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ column position_id
                String name = rs.getString("position_name");//lấy giá trị từ column position_name

                Position po = new Position(id, PositionName.valueOf(name));
                positions.add(po);
            }
            JDBCUtils.closeConnection(connection, prepareStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        }
        return positions;
    }


}


