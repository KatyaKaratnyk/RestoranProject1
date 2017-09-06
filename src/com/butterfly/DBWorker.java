package com.butterfly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/restoran";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "657493";
    private Connection conn = null;

    public DBWorker() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
    public void closeConn() {
        try {
            this.getConn().close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(this.getConn() != null) {
                    this.getConn().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
