package chapter7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task8 {

    private static final String FILE_PATH = "src/main/resources/countwords";

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        Map<String, Set<Integer>> wordsToLinesMap = extractWordsToLinesIndexesMap(lines);

        wordsToLinesMap.forEach((key, value) -> {
            System.out.print("Word " + key);
            System.out.println(" Occurrences in lines ");
            value.forEach(integer -> System.out.print(integer + " "));
            System.out.println();
        });
    }

    private static Map<String, Set<Integer>> extractWordsToLinesIndexesMap(List<String> lines) {
        Map<String, Set<Integer>> wordsToLinesMap = new HashMap<>();

        for(int i = 0; i < lines.size(); i++) {
            int index = i;
            String line = lines.get(i);
            String[] words = line.split(" ");

            Arrays.stream(words).forEach(word -> {
                if(wordsToLinesMap.containsKey(word)) {
                    wordsToLinesMap.get(word).add(index);
                } else {
                    Set<Integer> rowsIndexes = new HashSet<>();
                    rowsIndexes.add(index);
                    wordsToLinesMap.put(word, rowsIndexes);
                }
            });
        }

        return wordsToLinesMap;
    }


}
