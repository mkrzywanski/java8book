package chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Task3 {

    private static final String DIR_PATH = "src/main/resources/books";
    private static final String WORD_TO_BE_FOUND = "world";

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        List<Callable<String>> tasks = new LinkedList<>();

        Files.list(Paths.get(DIR_PATH)).
                forEach(path -> tasks.add(createCallableForPath(path)));

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        String filePath = executorService.invokeAny(tasks);

        System.out.println("First file which was found " + filePath);

        shutDown(executorService);

    }

    private static Callable<String> createCallableForPath(Path path) {
        return () -> {

            System.out.println("Invoked task for path " + path.toString());

            List<String> words = Files.lines(path)
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                    .collect(Collectors.toList());

            boolean isWordFound = false;
            int counter = 0;

            while (!isWordFound && counter < words.size()) {

                System.out.println(path.toString() + " " + counter);

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread for path " + path.toString() + " was interrupted");
                    return null;
                }

                String currentWord = words.get(counter);

                if (currentWord.equals(WORD_TO_BE_FOUND)) {
                    isWordFound = true;
                } else {
                    counter++;
                }

            }

            //Here it is needed in case when file is really short and has no occurrence of given word
            //In such case invokeAny method would assume that given thread executed task successfully although the word has not been found
            //Other threads in pool would be cancelled and processing would be stopped
            if(!isWordFound) {
                throw new WordNotFoundException("Word not found in file " + path.toString());
            }

            return path.getFileName().toString();

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

    private static class WordNotFoundException extends Exception {
        WordNotFoundException(String s) {
            super(s);
        }
    }

}
