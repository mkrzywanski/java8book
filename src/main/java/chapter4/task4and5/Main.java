package chapter4.task4and5;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Shape circle = new Circle(new Point(1,2), 3);
        Shape line = new Line(new Point(-3,3), new Point(3,-3));
        Shape rectangle = new Rectangle(new Point(-5,-2), 3, 2);

        System.out.println("Circle center : " + circle.getCenter());
        System.out.println("Line center : " + line.getCenter());
        System.out.println("Rectangle center : " + rectangle.getCenter());

        Shape circleClone = circle.clone();

        System.out.println("Circle : " + circle);
        System.out.println("Circle cloned : " + circleClone);

    }
}
