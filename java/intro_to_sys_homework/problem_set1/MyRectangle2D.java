public class MyRectangle2D {

    private double x;
    private double y;
    private double height;
    private double width;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public MyRectangle2D() {
        this.height = 1;
        this.width = 1;
        this.x = 0;
        this.y = 0;
    }

    public MyRectangle2D(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return width*2 + height*2;
    }

    boolean contains(int x1, int y1) {
        if ((x1<=x+width/2 && x1>=x-width/2) && (y1<=y+height/2 && y1>=y-height/2)) {
            return true;
        } else {
            return false;
        }
    }

    boolean contains(MyRectangle2D r) {
        if ( ((r.x-r.width/2 >= x-width/2) && (r.y-r.height/2 <= y-height/2))
                && ((r.x+r.width/2 <= x+width/2) && (r.y+r.height/2 <= y+height/2)) ){
            return true;
        } else {
            return false;
        }
    }

    boolean overlaps(MyRectangle2D r) {
        if (( (r.x+r.width/2>=x-width/2)| (r.x-r.width/2>=x+width/2)) &&
                ((r.y+r.height/2>=y-height/2)) | (r.y-r.height/2<=y+height/2)) {
            return true;
        } else {
            return false;
        }
    }
}

