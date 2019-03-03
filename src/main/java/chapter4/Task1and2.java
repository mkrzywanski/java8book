package chapter4;

public class Task1and2 {
    private static class Point {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class LabelledPoint extends Point {
        private String label;

        LabelledPoint(int x, int y, String label) {
            super(x, y);
            this.label = label;
        }

        String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return "LabelledPoint{" +
                    "x=" + super.getX() +
                    ", y=" + super.getY() +
                    ", label='" + label + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof LabelledPoint)) return false;
            if (!super.equals(o)) return false;

            LabelledPoint that = (LabelledPoint) o;
            return label.equals(that.label);
        }

        @Override
        public int hashCode() {
            int result = super.hashCode();
            result = 31 * result + label.hashCode();
            return result;
        }
    }

    public static void main(String[] args) {
        Point point = new Point(1,2);
        Point labelledPoint = new LabelledPoint(2,4, "label");

        System.out.println(point);
        System.out.println(labelledPoint);
    }
}
