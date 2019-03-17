package chapter9;

import java.io.*;
import java.util.Arrays;

public class Task14 {

    private static final String FILE_PATH = "src/main/resources/array_serialize";

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Point[] points = new Point[] {new Point(1,2), new Point(3,4)};
        serialize(points);

        Point[] points1 = deserialize();

        Arrays.stream(points1).forEach(System.out::println);

    }

    private static void serialize(Point[] array) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        objectOutputStream.writeObject(array);
        objectOutputStream.close();
    }

    private static Point[] deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Object deserialized = objectInputStream.readObject();
        objectInputStream.close();

        return (Point[]) deserialized;
    }

    private static class Point implements Serializable {

        private static final long serialVersionUID = 1;

        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y;
        }

        void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
