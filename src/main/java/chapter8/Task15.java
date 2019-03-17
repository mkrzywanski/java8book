package chapter8;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Task15 {

    private static final BigInteger INITIAL_VALUE = new BigInteger("1000000000000000000000000000000000000000000000000000000");
    private static final BigInteger ONE = new BigInteger("1");

    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(1);

        long startTime = System.currentTimeMillis();

        Stream.iterate(INITIAL_VALUE , bigInteger -> bigInteger.add(ONE))
                .parallel()
                .limit(100000)
                .filter(bigInteger -> bigInteger.isProbablePrime(1))
                .limit(500)
                .forEach(bigInteger -> System.out.println("Number " + atomicInteger.getAndIncrement() + " " + bigInteger));

        long time = System.currentTimeMillis() - startTime;

        System.out.println("Time " + time + " ms");
    }
}
