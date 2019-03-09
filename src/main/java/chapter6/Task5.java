package chapter6;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        Double[] result = Task5.<Double>zamiana(0, 1 , 1.5, (double) 2, (double) 3);
        System.out.println(Arrays.toString(result));
    }

    private static <T> T[] zamiana(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }
}
