package com.example.uts_2072029_axelshirasapatanegara.model;

public class WatchList {
    private int idWatchList;
    private int LastWatch;
    private int Favorite;
    private Movie idMovie;
    private User idUser;


    @Override
    public String toString() {
        return "WatchList{" +
                "idWatchList=" + idWatchList +
                ", LastWatch=" + LastWatch +
                ", Favorite=" + Favorite +
                ", idMovie=" + idMovie +
                ", idUser=" + idUser +
                '}';
    }

    public WatchList() {

    }

    public WatchList(int idWatchList, int lastWatch, int favorite, Movie idMovie, User idUser) {
        this.idWatchList = idWatchList;
        LastWatch = lastWatch;
        Favorite = favorite;
        this.idMovie = idMovie;
        this.idUser = idUser;
    }

    public String getLastWatchLengkap() {
        return "" + LastWatch + " /" + idMovie.getDurasi();
    }

    public boolean getFavoriteBoolean() {
        boolean temp;
        if (Favorite == 0) {
            temp = false;
        } else {
            temp = true;
        }
        return temp;
    }

    public int getIdWatchList() {
        return idWatchList;
    }

    public void setIdWatchList(int idWatchList) {
        this.idWatchList = idWatchList;
    }

    public int getLastWatch() {
        return LastWatch;
    }

    public void setLastWatch(int lastWatch) {
        LastWatch = lastWatch;
    }

    public int getFavorite() {
        return Favorite;
    }

    public void setFavorite(int favorite) {
        Favorite = favorite;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
        this.idMovie = idMovie;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }
}
