package com.example.uts_2072029_axelshirasapatanegara.dao;

import com.example.uts_2072029_axelshirasapatanegara.model.Movie;
import com.example.uts_2072029_axelshirasapatanegara.util.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao implements DaoInterface<Movie>{
    @Override
    public ObservableList<Movie> getData() {
        ObservableList<Movie> mList;
        mList = FXCollections.observableArrayList();

        Connection conn = MySQLConnection.getConnection();
        String query = "SELECT * FROM movie";
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
                mList.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }

    @Override
    public int addData(Movie data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "INSERT INTO movie(idMovie, Title, Genre, Durasi) VALUES (?,?,?,?)";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdMovie());
            ps.setString(2, data.getTitle());
            ps.setString(3, data.getGenre());
            ps.setInt(4, data.getDurasi());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int deleteData(Movie data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "DELETE FROM movie WHERE idMovie = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, data.getIdMovie());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    @Override
    public int updateData(Movie data) {
        Connection conn = MySQLConnection.getConnection();
        String query = "UPDATE user SET Title = ?, Genre = ?, Durasi = ? WHERE idMovie = ?";
        PreparedStatement ps;
        int hasil;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, data.getTitle());
            ps.setString(2, data.getGenre());
            ps.setInt(3, data.getDurasi());
            ps.setInt(4, data.getIdMovie());
            hasil = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hasil;
    }

    public ObservableList<Movie> filterData(String data) {
        ObservableList<Movie> mList;
        mList = FXCollections.observableArrayList();
        Connection conn = MySQLConnection.getConnection();
        String query = "SELECT * FROM movie WHERE Genre LIKE '%' ? '%'";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Movie m = new Movie();
                m.setIdMovie(rs.getInt("idMovie"));
                m.setTitle(rs.getString("Title"));
                m.setGenre(rs.getString("Genre"));
                m.setDurasi(rs.getInt("Durasi"));
                mList.add(m);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mList;
    }
}
