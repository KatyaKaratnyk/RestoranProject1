package com.butterfly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MenuManager implements DBManager<String, Dish> {
    private DBWorker worker;
    private DBWorkerFactory dbWorkerFactory = new DBWorkerFactory();
    private String DBName;

    public MenuManager(String DBName) {
        this.DBName = DBName;
    }

    public  ArrayList<Dish> getMenu() {
        Statement stmt = null;
        ArrayList<Dish> menu = new ArrayList<>();
        worker = dbWorkerFactory.createDWorker(DBName);
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
        return menu;
    }
    public void printMenu() {
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
    public boolean check(String s) {
        boolean b= false;
        for (Dish e: this.getMenu()) {
            if(e.getNameDish().equalsIgnoreCase(s)) {
                b = true;
                break;
            }
        }
        return b;
    }

    public Dish get(String name) {
        Dish k = null;
        for (Dish e : this.getMenu()) {
            if (name.equalsIgnoreCase(e.getNameDish())) {
                k = e;
            }
        }
        return k;
    }
    public void addDish(String name, double price) {
        if(!this.check(name)) {
            PreparedStatement stmt = null;
            worker = dbWorkerFactory.createDWorker(DBName);
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
        else System.out.println("Such dish has existed already");
    }
    public void delete(String name) {
        if(this.check(name)) {
            PreparedStatement stmt = null;
            worker = dbWorkerFactory.createDWorker(DBName);
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
        else System.out.println("Such dish doesn`t exist");
    }
}
