module com.example.uts_2072029_axelshirasapatanegara {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;


    opens com.example.uts_2072029_axelshirasapatanegara to javafx.fxml;
    exports com.example.uts_2072029_axelshirasapatanegara;
    exports com.example.uts_2072029_axelshirasapatanegara.controller;
    opens com.example.uts_2072029_axelshirasapatanegara.controller to javafx.fxml;
    exports com.example.uts_2072029_axelshirasapatanegara.model;
    opens com.example.uts_2072029_axelshirasapatanegara.model to javafx.fxml;
    exports com.example.uts_2072029_axelshirasapatanegara.dao;
    opens com.example.uts_2072029_axelshirasapatanegara.dao to javafx.fxml;
    exports com.example.uts_2072029_axelshirasapatanegara.util;
    opens com.example.uts_2072029_axelshirasapatanegara.util to javafx.fxml;
}