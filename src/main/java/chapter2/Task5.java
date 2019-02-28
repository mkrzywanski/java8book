package chapter2;

public class Task5 {
    public static void main(String[] args) {
        Point point = new Point(3,4).translate(1,3).scale(0.5);
        System.out.println("x = " + point.x);
        System.out.println("y = " + point.y);
    }

    private static class Point {
        private final double x;
        private final double y;

        private Point() {
            this.x = 0;
            this.y = 0;
        }

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }


        private Point translate(int offsetX, int offsetY) {
            double newX = this.x + offsetX;
            double newY = this.y + offsetY;
            return new Point(newX,  newY);
        }

        private Point scale(double rate) {
            double newX = this.x * rate;
            double newY = this.y * rate;
            return new Point(newX, newY);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

}
