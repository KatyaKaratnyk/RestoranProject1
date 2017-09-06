package com.butterfly;

public class Client {
    private static int id;
    private int idClient;
    private Order order;

    public Client (Order order) {
        ++id;
        this.idClient = id;
        this.order = order;

    }

    public int getIdClient() {
        return idClient;
    }

    public Order getOrder() {
        return order;
    }
}
