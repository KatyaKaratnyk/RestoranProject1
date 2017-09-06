package com.butterfly;


public class Administrator{
    private MenuManager menu;
    private OrderManager orderManager;

    public Administrator() {
        menu = new MenuManager();
        orderManager = new OrderManager();
    }
    //Removes a dish from the database by the name of the dish
    private void deleteDish(String name) {
        menu.delete(name);
    }
    //Deletes orders from the base by order number
    protected void deleteOrder(int idOrder) {
        orderManager.delete(idOrder);
    }
    //Adds a meal to the database
    private void addDish(String name, double price) {
        menu.addDish(name, price);
    }
    //Represents a menu in a friendly form
    public void printMenu() {
        menu.printMenu();
    }
    //Adding an order to the database
    public void addOrder(Order order) {
        orderManager.add(order);
    }
    //Represents an order in a friendly form
    public void printOrder(int idOrder) {
        orderManager.printOrder(idOrder);
    }
    //Checks whether the dish is in the menu in the database
    public boolean checkDish(String name) {
        return menu.check(name);
    }
    //Returns a dish by name from the database
    public Dish getDish(String name) {
        return menu.get(name);
    }
    //Returns the order by the order number from the database
    public Order getOrder(int idOrder) {
        return orderManager.get(idOrder);
    }
    //Changes the order status from 0 to 1. That is, the order becomes paid
    public void getPayment(int idOrder) {
        orderManager.payOrder(idOrder);
    }
}
