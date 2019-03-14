package chapter8;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task11 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.iterate(0, i -> i += 1);
        System.out.println(isFinite(intStream.boxed()));
    }

    private static <T> boolean isFinite(Stream<T> stream) {
        return stream.spliterator().estimateSize() != Long.MAX_VALUE;
    }
}
