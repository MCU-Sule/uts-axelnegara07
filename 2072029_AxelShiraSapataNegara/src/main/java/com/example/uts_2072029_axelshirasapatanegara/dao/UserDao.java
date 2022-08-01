package com.example.uts_2072029_axelshirasapatanegara.dao;

import com.example.uts_2072029_axelshirasapatanegara.model.User;
import com.example.uts_2072029_axelshirasapatanegara.util.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DaoInterface<User>{
    @Override
    public ObservableList<User> getData() {
        ObservableList<User> uList;
        uList = FXCollections.observableArrayList();

        Connection conn = MySQLConnection.getConnection();
        String query = "SELECT * FROM user";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery() ;
            while (rs.next()) {
                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("UserName"));
                u.setUserPassword(rs.getString("UserPassword"));
                uList.add(u);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return uList;
    }

    @Override
    public int addData(User data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "INSERT INTO user(idUser, UserName, UserPassword) VALUES (?,?,?)";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdUser());
            ps.setString(2, data.getUserName());
            ps.setString(3, data.getUserPassword());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int deleteData(User data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "DELETE FROM user WHERE idUser = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdUser());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(User data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "UPDATE user SET UserName = ?, UserPassword = ? WHERE idUser = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, data.getUserName());
            ps.setString(2, data.getUserPassword());
            ps.setInt(3, data.getIdUser());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }
}
