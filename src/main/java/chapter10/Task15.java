package chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task15 {

    private static final String DIR_PATH = "src/main/resources/books";

    public static void main(String[] args) throws IOException {

        Map<String, Long> wordToOccurrences = Files.list(Paths.get(DIR_PATH))
                .parallel()
                .map(path -> {
                    try {
                        return Files.lines(path)
                                .map(line -> line.split(" "))
                                .flatMap(Arrays::stream)
                                .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .reduce((stringLongMap, stringLongMap2) -> {
                    Map<String, Long> result = new HashMap<>();
                    stringLongMap.forEach((word, occurrences) -> result.merge(word, occurrences, Long::sum));
                    stringLongMap2.forEach((word, occurrences) -> result.merge(word, occurrences, Long::sum));
                    return result;
                }).orElseGet(HashMap::new);

        wordToOccurrences.forEach((s, aLong) -> System.out.println("Word " + s + " occurrences " + aLong));

    }
}
