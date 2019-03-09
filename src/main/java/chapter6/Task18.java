package chapter6;

import java.util.Arrays;
import java.util.function.IntFunction;

public class Task18 {
    public static void main(String[] args) {
        Integer[] arr = repeat(10, 42, Integer[]::new);

        Arrays.stream(arr)
                .forEach(System.out::println);
    }

    private static <T> T[] repeat(int n, T obj, IntFunction<T[]> intFunction) {
        T[] array = intFunction.apply(n);

        Arrays.fill(array, obj);

        return array;
    }

}
