package com.butterfly;

public class Restaurant {
    private Administrator administrator;
    private Waiter waiter;

    public Restaurant() {
        administrator = new Administrator();
        waiter = new Waiter();
    }

    public  void begin() {
        waiter.showMenu();
        waiter.noteOrder();
        waiter.printOrder();
        waiter.getPayment();
    }

    public Administrator getAdministrator() {
        return administrator;
    }

}
