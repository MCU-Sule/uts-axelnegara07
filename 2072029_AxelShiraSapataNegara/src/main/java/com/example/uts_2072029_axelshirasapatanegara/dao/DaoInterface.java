package com.example.uts_2072029_axelshirasapatanegara.dao;

import javafx.collections.ObservableList;

public interface DaoInterface<T> {
    ObservableList<T> getData();
    int addData(T data);
    int deleteData(T data);
    int updateData(T data);
}
