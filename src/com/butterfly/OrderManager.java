package com.butterfly;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderManager {
    private DBWorker worker;

    public void addOrder(Order order) {
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {

            stmt = worker.getConn().prepareStatement("INSERT INTO orders(orderDate) VALUES(current_timestamp)");
            stmt.executeUpdate();
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID() as m FROM restoran.orders");
            while (resultSet.next()) {
                order.setIdOrder(resultSet.getInt("m"));
            }

            for (Item e:order.getItems()) {

                stmt = worker.getConn().prepareStatement("insert into orderitems(orderId, dishId, quantity, price) Values(?,?,?,?)");
                stmt.setInt(1, order.getIdOrder());
                stmt.setInt(2, e.getIdDish());
                stmt.setInt(3, e.getQuantity());
                stmt.setDouble(4, e.getPriceDish());
                stmt.executeUpdate();
            }
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

    public Order takeOrder(int idOrder) {
        Order order = new Order();
        order.setIdOrder(idOrder);
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {
            stmt = worker.getConn().prepareStatement("Select sum(orderitems.quantity*orderitems.price) as m from orderitems where orderitems.orderId = ?");
            stmt.setInt(1, idOrder);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                order.setPriceOrder(rs.getDouble("m"));
            }
            stmt = worker.getConn().prepareStatement("Select orderDate  from orders where orders.orderId = ?");
            stmt.setInt(1, idOrder);
            rs = stmt.executeQuery();
            while (rs.next()) {
                order.setDataOrder(rs.getDate("orderDate"));
            }
            stmt = worker.getConn().prepareStatement("Select menu.name, orderitems.quantity,menu.price from menu join orderitems on menu.dishId=orderitems.dishId where orderitems.orderId=?");
            stmt.setInt(1, idOrder);
            rs = stmt.executeQuery();
            while (rs.next()) {
                order.getItems().add(new Item(rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price")));
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
        return order;
    }

    public boolean checkOrder(int idOrder) {
        boolean b= false;
        worker = new DBWorker();
        PreparedStatement stmt = null;
        Date date = new Date();
        try {
            stmt = worker.getConn().prepareStatement("Select orderDate from orders where orders.orderId = ?");
            stmt.setInt(1, idOrder);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                date = rs.getDate("orderDate");
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
        if(date != null) b =true;
        return b;
    }

    public boolean isPaid(int idOrder) {
        boolean b= false;
        worker = new DBWorker();
        PreparedStatement stmt = null;
        int k =0;
        try {
            stmt = worker.getConn().prepareStatement("Select isPaid from orders where orders.orderId = ?");
            stmt.setInt(1, idOrder);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                k = rs.getInt("isPaid");
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
        if(k == 1) b =true;
        return b;
    }

    public void payOrder(int idOrder) {
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {
            stmt = worker.getConn().prepareStatement("update orders set isPaid=1 where orders.orderId = ?");
            stmt.setInt(1, idOrder);
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

    public void printOrder(int idOrder) {
        Order order = this.takeOrder(idOrder);
        System.out.println("Number`s your order is: "+idOrder+". \nDate of create is: "+order.getDataOrder());
        for(Item e: order.getItems()) {
            int p = 30 - (e.getNameDish().length() + ("" + e.getQuantity()).length());
            String s = "";
            while (p >= 0) {
                s = s + ".";
                p--;
            }
            System.out.print(e.getNameDish() + s);
            System.out.println(e.getQuantity()+"x"+e.getPriceDish());
        }
        System.out.println("Total price: "+order.getPriceOrder());
    }

    public void deleteDish(int idOrder) {
        worker = new DBWorker();
        PreparedStatement stmt = null;
        try {
            stmt = worker.getConn().prepareStatement("delete from orders where orders.orderId = ?");
            stmt.setInt(1, idOrder);
            stmt.executeUpdate();
            stmt = worker.getConn().prepareStatement("delete from orderitem where orders.orderId = ?");
            stmt.setInt(1, idOrder);
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
