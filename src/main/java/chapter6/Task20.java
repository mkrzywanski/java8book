package chapter6;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Task20 {
    public static void main(String[] args) {
        Integer[] integers = repeat(10, 1,2,3);

        Arrays.stream(integers).forEach(System.out::println);
    }

    @SafeVarargs
    @SuppressWarnings("unchecked")
    private static <T> T[] repeat(int n, T... objs) {

        T[] result = (T[]) Array.newInstance(objs.getClass().getComponentType(), n * objs.length);

        int index = 0;
        for(int i = 0; i < n; i++) {
            for (T obj : objs) {
                result[index++] = obj;
            }
        }

        return result;
    }
}
