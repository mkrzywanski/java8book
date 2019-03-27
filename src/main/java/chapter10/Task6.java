package chapter10;

import com.google.common.collect.Sets;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Task6 {
    private static final String FILE_PATH = "src/main/resources/books";

    private static final ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException {

        List<Path> files = Files.list(Paths.get(FILE_PATH)).collect(Collectors.toList());

        List<Runnable> runnables = new LinkedList<>();

        files.forEach(path -> runnables.add(getRunnable(path)));

        ExecutorService executorService = Executors.newFixedThreadPool(files.size());

        runnables.forEach(executorService::submit);

        shutDown(executorService);

        map.forEach((word, files1) ->
                System.out.println("Word \"" + word + "\" appeared in files" +
                        files1.stream()
                                .map(File::getName)
                                .collect(Collectors.joining(" && "))
                )
        );

    }


    private static Runnable getRunnable(Path path) {
        return () -> {
            try {
                Files.lines(path)
                        .map(line -> line.split(" "))
                        .flatMap(Arrays::stream)
                        .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                        .forEach(s -> map.computeIfAbsent(s, s1 -> new HashSet<>())
                                .add(path.toFile()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private static void shutDown(ExecutorService executorService) {

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(50, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
