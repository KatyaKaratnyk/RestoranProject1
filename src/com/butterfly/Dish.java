package com.butterfly;

public class Dish {
    private int idDish;
    private String nameDish;
    private double priceDish;

    public Dish(int idDish, String nameDish, double priceDish) {
        this.idDish = idDish;
        this.nameDish = nameDish;
        this.priceDish = priceDish;
    }
    public Dish() {

    }

    public int getIdDish() {
        return idDish;
    }

    public String getNameDish() {
        return nameDish;
    }

    public double getPriceDish() {
        return priceDish;
    }

    @Override
    public String toString() {
        return this.nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public void setPriceDish(double priceDish) {
        this.priceDish = priceDish;
    }
}
