package com.example.Singleton;

public class Singleton {

    // the method is public and static
    public static Singleton instance = null;
    private Singleton() {

    }
    // static method to create instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
