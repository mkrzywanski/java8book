package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Task7 {

    private static final String FILE_PATH = "src/main/resources/countwords";
    private static final String SEPARATOR = " ";

    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        Map<String, Integer> wordsToOccurrences = countWords(lines);

        wordsToOccurrences.forEach((key, value) -> System.out.println("Word "
                + key
                + " Occurences "
                + value));
    }

    private static Map<String, Integer> countWords(List<String> lines) {

        Map<String, Integer> wordsToOccurrences = new TreeMap<>();

        lines.stream()
                .map(line -> line.split(SEPARATOR))
                .flatMap(Arrays::stream)
                .forEach(word -> wordsToOccurrences.merge(word,1, Integer::sum));

        return wordsToOccurrences;
    }
}
