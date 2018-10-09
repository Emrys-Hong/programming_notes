package com.example.lib01;


public interface Subject {
    void register(Observer o);
    void unregister(Observer o);

    void notifyObservers();

}
