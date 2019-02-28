package chapter2;

public class Task3 {

    public static void main(String[] args) {
        Point point = new Point(1,1);
        point.modifyInternalValues(3,3);
        point.print();
    }


    private static class Point {
        int x;
        int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        //modifying method which returns boolean
        private boolean modifyInternalValues(int x, int y) {
            this.x = x;
            this.y = y;
            return true;
        }

        //accesing method which returns void
        private void print() {
            System.out.println(x + " " + y);
        }

    }
}
