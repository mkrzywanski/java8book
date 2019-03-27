package chapter10.task14;

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

        ExecutorCompletionService<Map<String, Integer>> executorCompletionService = new ExecutorCompletionService<>(executorService);

        tasks.forEach(executorCompletionService::submit);

        Map<String, Integer> result = new HashMap<>();

        for(int i = 0; i < tasks.size(); i++) {
            try {
                Future<Map<String, Integer>> future = executorCompletionService.take();
                Map<String, Integer> res = future.get();
                res.forEach((word, occurrences) -> result.merge(word, occurrences, Integer::sum));
            } catch (InterruptedException | ExecutionException e) {
                System.out.println("One of workers was interrupted.");
            }
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
