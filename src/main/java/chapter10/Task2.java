package chapter10;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Task2 {

    private static final int NUMBERS_LIMIT = 100000;
    private static final int RANDOM_MAX_VALUE = 1000;
    private static final SecureRandom secureRandom = new SecureRandom();

    public static void main(String[] args) {

        Integer[] array = generateNewArray();

        Integer[] array2 = Arrays.copyOf(array, 0);

        System.out.println("Arrays.sort " + measureInvocationTime(array, Arrays::sort));

        System.out.println("Arrays.parallel sort " + measureInvocationTime(array2, Arrays::sort));

    }

    private static <T> long measureInvocationTime(T[] array, Consumer<T[]> consumer) {
        long begin = System.currentTimeMillis();

        consumer.accept(array);

        return System.currentTimeMillis() - begin;
    }

    private static Integer[] generateNewArray() {
        return Stream.generate(() -> secureRandom.nextInt(RANDOM_MAX_VALUE))
                .limit(NUMBERS_LIMIT)
                .toArray(Integer[]::new);
    }
}
