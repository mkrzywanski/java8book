package chapter4.task4and5;

public class Line extends Shape {
    private Point lineTo;

    public Line(Point pointFrom, Point lineTo) {
        super(pointFrom);
        this.lineTo = lineTo;
    }

    @Override
    public Point getCenter() {
        double centerX = (point.getX() + lineTo.getX()) / 2;
        double centerY = (point.getY() + lineTo.getY()) / 2;

        return new Point(centerX, centerY);
    }

    @Override
    public String toString() {
        return "Line{" +
                "lineTo=" + lineTo +
                ", point=" + point +
                '}';
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line clone = (Line) super.clone();
        clone.lineTo = lineTo.clone();
        return clone;
    }
}
