package chapter4;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        System.out.println(toString(Field.class));
    }

    private static String toString(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(fields)
                .forEach(field -> stringBuilder.append(field.getName()).append("\n"));

        return stringBuilder.toString();
    }
}
