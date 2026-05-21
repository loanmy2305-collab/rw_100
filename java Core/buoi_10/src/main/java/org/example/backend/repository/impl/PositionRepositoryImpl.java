package org.example.backend.repository.impl;

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
import java.util.Objects;

public class PositionRepositoryImpl implements IPositionRepository {

    @Override
    public List<Position> findAll() {
        List<Position> positions = new ArrayList<>();
        Connection connection = null;
        Statement statement =  null;
        ResultSet rs =  null;

        try {
            //b1 kết nốt Pos
            connection = JDBCUtils.getConnection();
            //b2:
            String sql = "select * from Position;";
            statement = connection.createStatement();
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("position_id");
                String name = rs.getString("position_name");
                PositionName positionName = PositionName.valueOf(name);
                Position po = new Position(id, positionName);
                positions.add(po);
            }
            JDBCUtils.closeConnection(connection, statement, rs);
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JDBCUtils.closeConnection(connection, statement, rs);
        }
        return positions;
    }

    @Override
    public boolean insert(String name) {
        Connection connection = null;
        PreparedStatement statement =  null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "insert into position (position_name) values (?); ";
            statement = connection.prepareStatement(sql);

            statement.setString(1, name);

            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;

    }

    @Override
    public boolean deletePosition(int id) {
        Connection connection = null;
        PreparedStatement statement =  null;

        try {
            connection = JDBCUtils.getConnection();

            String sql = "delete from position where account_id = ?;\n";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;
    }

    @Override
    public boolean updatePosition(int id, String updateName) {
        Connection connection = null;
        PreparedStatement statement =  null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "update position set position_name = ? where position_id = ? ";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, updateName);


            int c = statement.executeUpdate();
            JDBCUtils.closeConnection(connection, statement, null);
            return c > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection, statement, null);
        }
        return false;
    }

    @Override
    public List<Position> findByName(String searchName) {
        List<Position> positions = new ArrayList<>();// lưu lại dữ liệu lấy từ DB
        Connection connection = null;
        PreparedStatement prepareStatement =  null;
        ResultSet rs = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng position
            String sql = "select * from position where position_name like ?;";
            prepareStatement = connection.prepareStatement(sql);
            // set gia trị cho từng dấu ?
            prepareStatement.setString(1, searchName);

            rs = prepareStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs

            while (rs.next()) {// lặp qua qua từng dòng của rs
                int id = rs.getInt("position_id");// lấy giá trị từ column position_id
                String name = rs.getString("position_name");//lấy giá trị từ column position_name

                Position po = new Position(id, PositionName.valueOf(name));
                positions.add(po);
            }
            JDBCUtils.closeConnection(connection, prepareStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, prepareStatement, rs);
        }
        return positions;
    }

    @Override
    public boolean checkExistID(Integer id) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement prepareStatement =  null;
        ResultSet rs = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from position where position_id = ? ";

            prepareStatement = connection.prepareStatement(sql);
            prepareStatement.setInt(1, id);

            rs = prepareStatement.executeQuery();// thực thi câu lệnh sql và gán bảng trả ra vào ResultSet rs
            if (rs.next()) {// lặp qua qua từng dòng của rs
                check = true;
            }
            // đóng các kết nối
            JDBCUtils.closeConnection(connection, prepareStatement, rs);
        } catch (Exception e) {// show các lỗi lien quan đén logic xử lý
            e.printStackTrace();// show ra exception
        } finally {
            JDBCUtils.closeConnection(connection, prepareStatement, rs);
        }
        return check;
    }

    @Override
    public boolean checkExistNameAndIdNot(String name, Integer id) {
        boolean check = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        try {
            // b1: kết nối đến DB
            connection = JDBCUtils.getConnection();
            // b2: lấy dữ liệu từ bảng department
            String sql = "select * from position where position_name like ?";

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








