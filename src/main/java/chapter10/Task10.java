package chapter10;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Task10 {

    private static final AtomicLong ATOMIC_LONG = new AtomicLong(1);

    private static final String DIR_PATH = "src/main/resources/books";

    private static final BlockingQueue<File> QUEUE = new ArrayBlockingQueue<>(2);

    private static final String WORD_TO_BE_FOUND = "world";

    private static final File POISON_PILL = new File("end flag");

    private static final Integer CONSUMERS_AMOUNT = 3;

    public static void main(String[] args) {

        Runnable producer = getProducer();

        Runnable consumer = getConsumer();

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(producer);

        for (int i = 0; i < CONSUMERS_AMOUNT; i++) {
            executorService.execute(consumer);
        }

        shutDownThreadPool(executorService);

    }

    private static Runnable getConsumer() {
        return () -> {
            try {

                System.out.println("Thread " + ATOMIC_LONG.getAndIncrement() + " START");

                while (!Thread.currentThread().isInterrupted()) {

                    File file = QUEUE.take();

                    if (file == POISON_PILL) {
                        QUEUE.put(file);
                        System.out.println("POISON PILL CAUGHT");
                        return;
                    }

                    boolean found = Files.lines(file.toPath())
                            .map(line -> line.split(" "))
                            .flatMap(Arrays::stream)
                            .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                            .anyMatch(word -> word.equals(WORD_TO_BE_FOUND));

                    if (found) {
                        System.out.println(file.getName());
                    }
                }


            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
            }

        };
    }

    private static Runnable getProducer() {
        return () -> {
            try {
                Files.list(Paths.get(DIR_PATH))
                        .forEach(path -> QUEUE.add(path.toFile()));
                QUEUE.put(POISON_PILL);
            } catch (IOException | InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        };
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
