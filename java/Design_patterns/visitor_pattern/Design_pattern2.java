package design_pattern2;

import java.util.ArrayList;

public class Design_pattern2 {
    public static void main(String[] args) {
        ArrayList<Visitable> items = new ArrayList<>();
        PostCanada postage = new PostCanada();
        items.add(new Book(1));
        items.add(new CD(2));
        items.add(new Clothing(3));
        for(Visitable o:items) {
            o.accept(postage);
        }
        System.out.println(postage.getTotal());
    }
}

class Book implements Visitable {
    private double weight;

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Book(double weight){
        this.weight = weight;
    }
    public double getWeight() {
        return this.weight;
    }
}

class CD implements Visitable {
    private double weight;
    @Override
    public void accept(Visitor v){
        v.visit(this);
    }

    public double getWeight() {
        return this.weight;
    }
    public CD(double weight) {
        this.weight = weight;
    }
}

class Clothing implements Visitable {
    private double weight;
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public double getWeight() {
        return weight;
    }
    public Clothing(double weight) {
        this.weight = weight;
    }
}