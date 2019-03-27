package chapter10.task13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    private static final String DIR_PATH = "src/main/resources/books";

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<FileWorker> tasks = new LinkedList<>();

        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        Files.list(Paths.get(DIR_PATH))
                .forEach(path -> tasks.add(new FileWorker(concurrentMap, path.toFile())));

        tasks.forEach(executorService::submit);

        shutDownThreadPool(executorService);

        concurrentMap.forEach((word, occurrences) -> System.out.println("Word " + word + " occurrences " + occurrences));

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
