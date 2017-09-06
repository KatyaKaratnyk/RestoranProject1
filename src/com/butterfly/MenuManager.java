package com.butterfly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MenuManager {
    private DBWorker worker;
    private ArrayList<Dish> menu;

    public MenuManager() {
    menu = new ArrayList<>();
}
    public ArrayList<Dish> getMenu() {
        return menu;
    }

    public  void createMenu() {
        worker = new DBWorker();
        Statement stmt = null;
        try {
            String query = "Select dishId, name, price from menu";
            stmt = worker.getConn().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Dish dish = new Dish(rs.getInt("dishId"), rs.getString("name"), rs.getDouble("price"));
                menu.add(dish);
            }
            worker.closeConn();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
            }
        }
    }
    public void printMenu() {
        this.createMenu();
        for (Dish e : this.getMenu()) {
            int p = 30 - (e.getNameDish().length() + ("" + e.getPriceDish()).length());
            String s = "";
            while (p >= 0) {
                s = s + ".";
                p--;
            }
            System.out.print(e.getNameDish() + s);
            System.out.println(e.getPriceDish());
        }
    }
    public boolean checkDish(String s) {
        boolean b= false;
        worker = new DBWorker();
        PreparedStatement stmt = null;
        String name=null;
        try {
            stmt = worker.getConn().prepareStatement("Select name from menu where menu.name = ?");
            stmt.setString(1, s);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
            }
            worker.closeConn();
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
            }
        }
        if(name!= null) b =true;
        return b;
    }

    public Dish findDish(String name) {
        Dish k = null;
        for (Dish e : this.getMenu()) {
            if (name.equalsIgnoreCase(e.getNameDish())) {
                k = e;
            }
        }
        return k;
    }
    public void addDish(String name, double price) {
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {
            stmt = worker.getConn().prepareStatement("INSERT INTO menu(name, price) VALUES(?, ?)");
            stmt.setNString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
            worker.closeConn();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
            }
        }

    }
    public void deleteDish(String name) {
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {
            stmt = worker.getConn().prepareStatement("delete from menu where menu.name = ?");
            stmt.setNString(1, name);
            stmt.executeUpdate();
            worker.closeConn();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
            }
        }
    }
}
