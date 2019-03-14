package chapter8;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3 {

    public static void main(String[] args) {

        int[] ints = new int[]{ 1, 2, 3, 4, 5, 6 };

        Stream.of(ints).flatMapToInt(Arrays::stream).close();

        Arrays.stream(ints).close();

        IntStream.of(ints).close();

    }
}
