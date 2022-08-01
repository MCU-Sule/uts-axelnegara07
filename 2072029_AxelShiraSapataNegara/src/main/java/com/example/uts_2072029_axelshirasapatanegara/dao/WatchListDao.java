package com.example.uts_2072029_axelshirasapatanegara.dao;

import com.example.uts_2072029_axelshirasapatanegara.model.Movie;
import com.example.uts_2072029_axelshirasapatanegara.model.User;
import com.example.uts_2072029_axelshirasapatanegara.model.WatchList;
import com.example.uts_2072029_axelshirasapatanegara.util.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchListDao implements DaoInterface<WatchList>{

    @Override
    public ObservableList<WatchList> getData() {
        ObservableList<WatchList> wList;
        wList = FXCollections.observableArrayList();

        Connection conn = MySQLConnection.getConnection();
        String query = "SELECT * FROM watchlist w JOIN movie m ON w.Movie_idMovie = m.idMovie " +
                "JOIN user u ON w.User_idUser = u.idUser;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery() ;
            while (rs.next()) {
                Movie m = new Movie();
                m.setIdMovie(rs.getInt("idMovie"));
                m.setTitle(rs.getString("Title"));
                m.setGenre(rs.getString("Genre"));
                m.setDurasi(rs.getInt("Durasi"));

                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("UserName"));
                u.setUserPassword(rs.getString("UserPassword"));

                WatchList w = new WatchList();
                w.setIdWatchList(rs.getInt("idWatchList"));
                w.setIdWatchList(rs.getInt("LastWatch"));
                w.setIdWatchList(rs.getInt("Favorite"));
                w.setIdMovie(m);
                w.setIdUser(u);
                wList.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wList;
    }

    @Override
    public int addData(WatchList data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "INSERT INTO watchlist(User_idUser, LastWatch, Favorite, Movie_idMovie, User_idUser) VALUES (?,?,?,?,?)";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdWatchList());
            ps.setInt(2, data.getLastWatch());
            ps.setInt(3, data.getFavorite());
            ps.setInt(4, data.getIdMovie().getIdMovie());
            ps.setInt(5, data.getIdUser().getIdUser());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int deleteData(WatchList data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "DELETE FROM watchlist WHERE idWatchList = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdWatchList());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(WatchList data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "UPDATE watchlist SET LastWatch = ?, Favorite = ?, Movie_idMovie = ?, User_idUser = ? WHERE idWatchList = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getLastWatch());
            ps.setInt(2, data.getFavorite());
            ps.setInt(3, data.getIdMovie().getIdMovie());
            ps.setInt(4, data.getIdUser().getIdUser());
            ps.setInt(5, data.getIdWatchList());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    public ObservableList<WatchList> getDataUser(User data) {
        ObservableList<WatchList> wList;
        wList = FXCollections.observableArrayList();

        Connection conn = MySQLConnection.getConnection();
        String query = "SELECT * FROM watchlist w JOIN movie m ON w.Movie_idMovie = m.idMovie " +
                "JOIN user u ON w.User_idUser = u.idUser WHERE w.User_idUser = ?;";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdUser());
            ResultSet rs = ps.executeQuery() ;
            while (rs.next()) {
                Movie m = new Movie();
                m.setIdMovie(rs.getInt("idMovie"));
                m.setTitle(rs.getString("Title"));
                m.setGenre(rs.getString("Genre"));
                m.setDurasi(rs.getInt("Durasi"));

                User u = new User();
                u.setIdUser(rs.getInt("idUser"));
                u.setUserName(rs.getString("UserName"));
                u.setUserPassword(rs.getString("UserPassword"));

                WatchList w = new WatchList();
                w.setIdWatchList(rs.getInt("idWatchList"));
                w.setLastWatch(rs.getInt("LastWatch"));
                w.setFavorite(rs.getInt("Favorite"));
                w.setIdMovie(m);
                w.setIdUser(u);
                wList.add(w);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return wList;
    }
}
