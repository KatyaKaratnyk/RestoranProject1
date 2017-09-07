package com.butterfly;

public class Client {

    private Order order;

    public Client (Order order) {

        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
