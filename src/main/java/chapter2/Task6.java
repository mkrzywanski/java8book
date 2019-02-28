package chapter2;

public class Task6 {
    public static void main(String[] args) {
        Point point = new Point(3,4);
        point.translate(1,3);
        point.scale(0.5);

        System.out.println("x = " + point.x);
        System.out.println("y = " + point.y);
    }

    private static class Point {
        private double x;
        private double y;

        private Point() {
            this.x = 0;
            this.y = 0;
        }

        private Point(double x, double y) {
            this.x = x;
            this.y = y;
        }


        private void translate(int offsetX, int offsetY) {
            this.x += offsetX;
            this.y += offsetY;
        }

        private void scale(double rate) {
            this.x *= rate;
            this.y *= rate;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

}

