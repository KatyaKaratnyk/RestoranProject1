package com.butterfly;

import java.util.*;

public class Administrator {
    private Client client;
    private MenuManager menu;
    private OrderManager orderManager;

    public void showMenu() {
        System.out.println("Hello! Do you want to order something?");
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();
        if(b.equalsIgnoreCase("yes")) {
            menu = new MenuManager();
            menu.printMenu();
        } else {
            System.out.println("ok, bye.");
            System.exit(0);
        }
        System.out.println("Make your choice...");
    }

    public void noteOrder() {
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        String b = sc.nextLine();
        do {
            if (menu.checkDish(b)) {
                Dish d = menu.findDish(b);
                System.out.println("How much "+d.getNameDish()+"`s do you want to order?");
                Scanner sv = new Scanner(System.in);
                while (!sv.hasNextInt()) {
                    System.out.println("You enter not integer number");
                    sv.next();
                }
                Item item = new Item(d.getIdDish(), d.getNameDish(), d.getPriceDish(), sv.nextInt());
                order.addItem(item);
                System.out.println("Do you want something else?");
                b=sc.nextLine();
            } else {
                System.out.println("Sorry, but we haven`t such dish. Maybe something other?");
                b= sc.nextLine();
            }
        } while (!b.equalsIgnoreCase("no"));
        if(order.getItems().isEmpty()) {
            System.out.println("It's a pity that you did not like anything. Good-bye((");
            System.exit(0);
        }
        orderManager = new OrderManager();
        orderManager.addOrder(order);
        client = new Client(orderManager.takeOrder(order.getIdOrder()));
        System.out.println("Your order is submitted. Number your order is "+order.getIdOrder());
        System.out.println("There are your dishes. Enjoy!!!");
    }

    public void showOrder() {
        System.out.println("Do you want to pay?");
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();
        while (!b.equalsIgnoreCase("yes")) {
            System.out.println("Ok, I came back later.");
            System.out.println("Ten minutes left...");
            System.out.println("Maybe now?");
            b = sc.nextLine();
        }
        System.out.println("Ok. There is your order:");
        orderManager.printOrder(client.getOrder().getIdOrder());
    }
    public void getPayment() {
        double d = client.getOrder().getPriceOrder();
        System.out.println("Enter money:");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println("You enter not money");
            sc.next();
        }
        double v = sc.nextDouble();
        if(v==d) {
            orderManager.payOrder(client.getOrder().getIdOrder());
            System.out.println("Ok. Your order is paid. Good-bye!!");
        }
        if(v>d){
            double s = v-d;
            orderManager.payOrder(client.getOrder().getIdOrder());
            System.out.printf("Ok. Your order is paid. Here is your rest %.3f . Good-bye!!", s);
        }
        if(v<d) {
            System.out.println("It's not enough. We do not close your order. Wash the dishes, then we'll see.");
        }
    }
}