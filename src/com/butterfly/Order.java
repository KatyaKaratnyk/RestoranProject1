package com.butterfly;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Order {
    private int idOrder;
    private ArrayList<Item> items;
    private double priceOrder;
    private Date dataOrder;

    public Order() {
        items = new ArrayList<>();
    }
    public void addItem(Item item) {
        this.getItems().add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getPriceOrder() {
        return priceOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setPriceOrder(double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public Date getDataOrder() {
        return dataOrder;
    }

    public void setDataOrder(Date dataOrder) {
        this.dataOrder = dataOrder;
    }

    @Override
    public String toString() {
        return ""+this.getIdOrder()+" "+this.getDataOrder();
    }
}
