package design_pattern2;

public class PostCanada implements Visitor {
    private double total=0;
    @Override
    public void visit(Book b) {
        total += b.getWeight()*2;
    }
    @Override
    public void visit(CD c) {
        total += c.getWeight()*10;
    }
    @Override
    public void visit(Clothing c) {
        total += c.getWeight()*10;
    }

    public double getTotal() {
        return total;
    }
}
