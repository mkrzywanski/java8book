package chapter9;

import java.io.*;
import java.util.Arrays;

public class Task15 {
    private static final String FILE_PATH = "src/main/resources/array_serialize2";

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

        private static final long serialVersionUID = 2;

        private int[] arr = new int[2];

        Point(int x, int y) {
            this.arr[0] = x;
            this.arr[1] = y;
        }

        int getX() {
            return arr[0];
        }

        void setX(int x) {
            this.arr[0] = x;
        }

        int getY() {
            return arr[1];
        }

        void setY(int y) {
            this.arr[1] = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + arr[0] +
                    ", y=" + arr[1] +
                    '}';
        }
    }
}
