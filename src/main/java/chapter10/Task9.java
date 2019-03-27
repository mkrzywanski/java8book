package chapter10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;

public class Task9 {

    public static void main(String[] args) throws InterruptedException {

        LongAccumulator longAccumulator = new LongAccumulator((l, l1) -> l + l1, 0);

        Runnable runnable = () -> IntStream.range(0, 500).forEach(longAccumulator::accumulate);

        List<Thread> threadList = new LinkedList<>();

        IntStream.range(0, 500).forEach(integer -> threadList.add(new Thread(runnable)));

        for (Thread thread : threadList) {
            thread.run();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println(longAccumulator.get());
    }

}
