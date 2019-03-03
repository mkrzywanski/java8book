package chapter4.task4and5;

public class Circle extends Shape {

    private double radius;

    public Circle(Point point, double radius) {
        super(point);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return point;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point=" + point +
                '}';
    }

    @Override
    public Circle clone() throws CloneNotSupportedException {
        Circle clone = (Circle) super.clone();
        clone.radius = this.radius;
        return clone;
    }
}
