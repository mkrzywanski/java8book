package chapter10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Task8 {

    public static void main(String[] args) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong(0);

        Runnable atomicLongRunnable = () -> IntStream.range(0, 100000)
                .forEach(integer -> atomicLong.incrementAndGet());

        System.out.println("AtomicLong " + benchmark(atomicLongRunnable) + " ms. Value " + atomicLong.get());

        LongAdder longAdder = new LongAdder();

        Runnable longAdderRunnable = () -> IntStream.range(0, 1000)
                .forEach(integer -> longAdder.increment());

        System.out.println("LongAdder " + benchmark(longAdderRunnable) + " ms. Value " + longAdder.sum());


    }

    private static long benchmark(Runnable runnable) throws InterruptedException {
        List<Thread> threadList = new LinkedList<>();

        IntStream.range(0, 1000).forEach(integer -> threadList.add(new Thread(runnable)));

        long startTime = System.currentTimeMillis();

        for (Thread thread : threadList) {
            thread.run();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        return System.currentTimeMillis() - startTime;
    }
}
