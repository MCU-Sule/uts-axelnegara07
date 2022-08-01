package com.example.uts_2072029_axelshirasapatanegara.model;

public class Movie {
    private int idMovie;
    private String Title;
    private String Genre;
    private int Durasi;

    @Override
    public String toString() {
        return Title;
    }

    public Movie() {

    }

    public Movie(int idMovie, String title, String genre, int durasi) {
        this.idMovie = idMovie;
        Title = title;
        Genre = genre;
        Durasi = durasi;
    }

    public int getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(int idMovie) {
        this.idMovie = idMovie;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getDurasi() {
        return Durasi;
    }

    public void setDurasi(int durasi) {
        Durasi = durasi;
    }
}
