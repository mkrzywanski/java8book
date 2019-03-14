package chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Task16 {

    private static final String BOOK_FILE_PATH = "src/main/resources/war_and_peace";
    private static final String SEPARATOR = " ";
    private static final int WORDS_LIMIT = 500;

    public static void main(String[] args) throws IOException {

        Stream<String> parallel = Files.lines(Paths.get(BOOK_FILE_PATH))
                .parallel();

        Stream<String> notParallel = Files.lines(Paths.get(BOOK_FILE_PATH));

        System.out.println("Parallel stream time " + measureExecutionTime(parallel) + " ms");
        System.out.println("Not parallel stream time " + measureExecutionTime(notParallel) + " ms");

    }

    private static long measureExecutionTime(Stream<String> stringStream) {
        long start = System.currentTimeMillis();

        stringStream
                .flatMap(line -> Arrays.stream(line.split(SEPARATOR)))
                .map(word -> word.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+"))
                .distinct()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(WORDS_LIMIT)
                .forEach(System.out::println);

        return System.currentTimeMillis() - start;
    }
}
