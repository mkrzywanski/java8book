package chapter5;

import java.util.Arrays;

public class Task12 {
    public static void main(String[] args) {
        int[] values = new int[] {1,2,3,4,5};
        System.out.println(min(values));
    }

    private static int min(int[] values) {
        int min = Arrays.stream(values).min().getAsInt();

        assert Arrays.stream(values).allMatch(i -> i >= min);

        return min;
    }
}
