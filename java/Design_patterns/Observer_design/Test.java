package com.example.lib01;

public class Test {
    public static void main(String[] args) {
        Topic topic5001 = new Topic();
        Subscriber norman = new Subscriber(1, topic5001);
        Subscriber man = new Subscriber(2, topic5001);
        topic5001.somethingHappeng("there is a meeting");
    }
}
