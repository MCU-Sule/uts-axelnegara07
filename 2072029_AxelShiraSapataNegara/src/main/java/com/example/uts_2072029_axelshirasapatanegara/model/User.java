package com.example.uts_2072029_axelshirasapatanegara.model;

public class User {
    private int idUser;
    private String UserName;
    private String UserPassword;

    @Override
    public String toString() {
        return UserName;
    }

    public User() {

    }

    public User(int idUser, String userName, String userPassword) {
        this.idUser = idUser;
        UserName = userName;
        UserPassword = userPassword;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
