package com.butterfly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorkerRestaurant extends DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/restoran";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "657493";

    public DBWorkerRestaurant() {
        super.createConn(URL, USERNAME, PASSWORD);
    }

}
