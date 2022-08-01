package com.example.uts_2072029_axelshirasapatanegara.controller;

import com.example.uts_2072029_axelshirasapatanegara.HelloApplication;
import com.example.uts_2072029_axelshirasapatanegara.dao.MovieDao;
import com.example.uts_2072029_axelshirasapatanegara.dao.UserDao;
import com.example.uts_2072029_axelshirasapatanegara.dao.WatchListDao;
import com.example.uts_2072029_axelshirasapatanegara.model.Movie;
import com.example.uts_2072029_axelshirasapatanegara.model.User;
import com.example.uts_2072029_axelshirasapatanegara.model.WatchList;
import com.example.uts_2072029_axelshirasapatanegara.util.MySQLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class FirstController {
    @FXML
    public ListView lvUser;
    @FXML
    public TableView table2;
    @FXML
    public TableView table1;
    @FXML
    private TableColumn<String, Movie> colTitle;
    @FXML
    private TableColumn<String, Movie> colGenre;
    @FXML
    private TableColumn<Integer, Movie> colDurasi;
    @FXML
    private TableColumn<Integer, WatchList> colTitle2;
    @FXML
    private TableColumn<Integer, WatchList> colLast;
    @FXML
    private TableColumn<Integer, WatchList> colFavorite;
    @FXML
    public ComboBox<String> cmbGenre;
    ObservableList<Movie> mList;
    ObservableList<User> uList;
    ObservableList<WatchList> wList;
    private ObservableList<String> cList;
    public MovieDao movieDao = new MovieDao();
    public UserDao userDao = new UserDao();
    public WatchListDao watchListDao = new WatchListDao();

    public void initialize() {
        wList = watchListDao.getData();
        cList = FXCollections.observableArrayList(
                "All",
                "Action",
                "Musical",
                "Comedy",
                "Animated",
                "Fantasy",
                "Drama",
                "Mistery",
                "Thriller",
                "Horror"
        );
        cmbGenre.setItems(cList);
        cmbGenre.getSelectionModel().select(0);
        ShowData();
    }

    public void ShowData() {
        uList = userDao.getData();
        lvUser.setItems(uList);
        mList = movieDao.getData();
        table2.setItems(mList);
        colTitle.setCellValueFactory(new PropertyValueFactory<>("Title"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("Genre"));
        colDurasi.setCellValueFactory(new PropertyValueFactory<>("Durasi"));
    }

    public void changeCombo(ActionEvent actionEvent) {
        if (cmbGenre.getSelectionModel().getSelectedIndex() == 0) {
            table2.setItems(movieDao.getData());
        } else {
            table2.setItems(movieDao.filterData(cmbGenre.getValue()));
        }
    }

    public void AddUserAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("UTSSecondPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 333, 168);
        stage.setTitle("Category Management");
        stage.setScene(scene);
        stage.showAndWait();
        ShowData();
    }

    public void DelUserAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure?", ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            userDao.deleteData((User) lvUser.getSelectionModel().getSelectedItem());
        }
        ShowData();
    }

    public void printReport(ActionEvent actionEvent) {
        JasperPrint jp;
        Connection conn = MySQLConnection.getConnection();

        Map param = new HashMap();
        try {
            jp = JasperFillManager.fillReport("reports/Movie_Report_All.jasper", param, conn);
            JasperViewer viewer = new JasperViewer(jp, false);
            viewer.setTitle("Movie Report");
            viewer.setVisible(true);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnClickUser(MouseEvent mouseEvent) {
        wList = watchListDao.getDataUser((User) lvUser.getSelectionModel().getSelectedItem());
        table1.setItems(wList);
        colTitle2.setCellValueFactory(new PropertyValueFactory<>("idMovie"));
        colLast.setCellValueFactory(new PropertyValueFactory<>("LastWatchLengkap"));
        colFavorite.setCellValueFactory(new PropertyValueFactory<>("FavoriteBoolean"));
    }
}