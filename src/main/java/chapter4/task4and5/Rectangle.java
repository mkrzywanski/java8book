package chapter4.task4and5;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(Point topLeftPoint, double width, double height) {
        super(topLeftPoint);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        double x;

        if(point.getX() <= 0) {
            x = point.getX() + (width / 2);
        } else {
            x = point.getX() - (width / 2);
        }

        double y = point.getY() - (height / 2);

        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", point=" + point +
                '}';
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle clone = (Rectangle) super.clone();

        clone.width = width;
        clone.height = height;

        return clone;
    }
}
