package com.butterfly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DBWorker {
    private Connection conn = null;

    public void createConn(String s, String m, String t) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(s, m, t);
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
