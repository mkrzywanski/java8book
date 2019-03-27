package chapter10.task11;

import java.io.File;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Main {

    private static final int THREAD_POOL_SIZE = 6;
    private static final int FILE_WORKER_THREADS_AMOUNT = 4;

    public static void main(String[] args) {

        BlockingQueue<File> fileBlockingQueue = new ArrayBlockingQueue<>(4);
        BlockingQueue<Map<String, Integer>> mapBlockingQueue = new ArrayBlockingQueue<>(3);

        ExecutorService executor = Executors.newCachedThreadPool();

        FileProducer fileProducer = new FileProducer(fileBlockingQueue);
        OutputCombiner outputCombiner = new OutputCombiner(mapBlockingQueue);

        IntStream.range(0, FILE_WORKER_THREADS_AMOUNT)
                .forEach(i -> executor.execute(new FileWorker(fileBlockingQueue, mapBlockingQueue)));

        executor.execute(fileProducer);
        executor.execute(outputCombiner);

        shutDownThreadPool(executor);

    }

    private static void shutDownThreadPool(ExecutorService executorService) {
        executorService.shutdown();

        try {
            if(!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
