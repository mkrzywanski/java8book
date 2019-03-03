package chapter4.task4and5;

public abstract class Shape implements Cloneable
{
    protected Point point;

    public Shape(Point point) {
        this.point = point;
    }

    public void moveBy(double dx, double dy) {
        double newX = this.point.getX() + dx;
        double newY = this.point.getY() + dy;
        this.point = new Point(newX, newY);
    }

    public abstract Point getCenter();

    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape clone = (Shape) super.clone();

        clone.point = this.point.clone();

        return clone;
    }
}
