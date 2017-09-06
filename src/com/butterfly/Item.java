package com.butterfly;

public class Item extends Dish {

    private int quantity;

    public Item(int idDish, String nameDish, double priceDish, int quantity) {
        super(idDish, nameDish, priceDish);
        this.quantity = quantity;
    }
    public Item(String name, int quantity, double price) {
        this.setNameDish(name);
        this.quantity = quantity;
        this.setPriceDish(price);

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
