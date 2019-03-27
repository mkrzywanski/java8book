package chapter10.task12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Main {

    private static final String DIR_PATH = "src/main/resources/books";

    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newCachedThreadPool();

        List<FileWorker> tasks = new LinkedList<>();

        Files.list(Paths.get(DIR_PATH))
                .forEach(path -> tasks.add(new FileWorker(path.toFile())));

        Map<String, Integer> result = new HashMap<>();

        try {
            List<Future<Map<String, Integer>>> futures = executorService.invokeAll(tasks);
            for (Future<Map<String, Integer>> future : futures) {
                try {
                    Map<String, Integer> stringIntegerMap = future.get();
                    stringIntegerMap.forEach((s, integer) -> result.merge(s, integer, Integer::sum));
                } catch (ExecutionException e) {
                    System.out.println("Future error");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("One of tasks was interrupted");
        }


        result.forEach((s, integer) -> System.out.println("Word " + s + " occurrences " + integer));

        shutDownThreadPool(executorService);

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
