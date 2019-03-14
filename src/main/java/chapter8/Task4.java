package chapter8;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {

    }

    private static Stream<Long> getLinearCongruentialGenerator(long a, long c, long m, long seed) {
        return Stream.iterate(seed, formula(a, c, m));
    }

    private static UnaryOperator<Long> formula(long a, long c, long m) {
        return aLong -> (a * aLong + c) % m;
    }
}
