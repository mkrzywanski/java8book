package chapter4.task4and5;

public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        Point clone = (Point) super.clone();
        clone.x = this.x;
        clone.y = this.y;
        return clone;
    }
}
