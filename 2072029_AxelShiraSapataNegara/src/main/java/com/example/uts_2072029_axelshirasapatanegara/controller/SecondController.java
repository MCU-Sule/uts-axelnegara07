package com.example.uts_2072029_axelshirasapatanegara.controller;


import com.example.uts_2072029_axelshirasapatanegara.dao.UserDao;
import com.example.uts_2072029_axelshirasapatanegara.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class SecondController {
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;
    private UserDao userDao;

    public void submit(ActionEvent actionEvent) {
        if (txtUserName.getText().isEmpty() || txtPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Please fill the field", ButtonType.OK);
            alert.show();
        } else {
            String uName = txtUserName.getText();
            String uPassword = txtUserName.getText();
            userDao = new UserDao();
            userDao.addData(new User(0, uName, uPassword));
            txtUserName.getScene().getWindow().hide();
        }
    }
}