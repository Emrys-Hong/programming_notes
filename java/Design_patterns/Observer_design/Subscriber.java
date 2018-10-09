package com.example.lib01;

public class Subscriber implements Observer {
    private int id;
    private Subject subject;
    public Subscriber(int id, Subject subject){
        this.id = id;
        this.subject = subject;
        subject.register(this);
    }
    @Override
    public void update(String msg) {
        System.out.println(id+ "receives" + msg);

    }
}
