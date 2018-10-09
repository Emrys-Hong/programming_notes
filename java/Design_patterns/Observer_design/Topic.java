package com.example.lib01;

import java.util.ArrayList;

public class Topic implements Subject {
    private String message;
    private ArrayList<Observer> observerList = null;

    Topic() {
        observerList = new ArrayList<Observer>();

    }

    @Override
    public void register(Observer o) {
        observerList.add(o);

    }
    @Override
    public void unregister(Observer o) {
        observerList.remove(o);

    }

    @Override
    public void notifyObservers() {
        for (Observer o:observerList) {
            o.update(this.message);
        }
    }

    public void somethingHappeng(String msg) {
        this.message = msg;
        notifyObservers();
    }
}
