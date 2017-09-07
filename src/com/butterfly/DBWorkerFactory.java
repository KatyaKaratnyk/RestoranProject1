package com.butterfly;

public class DBWorkerFactory {
    public DBWorker createDWorker(String type) {
        DBWorker dbWorker = null;
        if(type.equalsIgnoreCase("restaurant")) {
            dbWorker = new DBWorkerRestaurant();
        }
        return dbWorker;
    }
}
