package com.butterfly;

public class Restoran {

    public static void begin() {
        Administrator admin = new Administrator();
        admin.showMenu();
        admin.noteOrder();
        admin.showOrder();
        admin.getPayment();
    }
}
