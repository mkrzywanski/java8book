package chapter9;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task2 {

    private static final String FILE_PATH = "src/main/resources/war_and_peace";
    private static final String TOC_FILE_PATH = "src/main/resources/war_and_peace_words.toc";


    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        Map<String, Set<Integer>> wordsToLinesMap = extractWordsToLinesIndexesMap(lines);

        saveToFile(wordsToLinesMap);

    }

    private static Map<String, Set<Integer>> extractWordsToLinesIndexesMap(List<String> lines) {
        Map<String, Set<Integer>> wordsToLinesMap = new HashMap<>();

        for(int i = 0; i < lines.size(); i++) {
            int index = i;
            String line = lines.get(i);
            line = line.replaceAll("[^a-zA-Z0-9 ]", "");
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

    private static void saveToFile(Map<String, Set<Integer>> wordsToLinesMap) throws IOException {
        FileWriter fileWriter = new FileWriter(TOC_FILE_PATH);

        fileWriter.append("War and peace book words TOC \n");

        wordsToLinesMap.forEach((word, rowsIndexes) -> {

            StringBuilder stringBuilder = new StringBuilder();

            rowsIndexes.forEach(integer -> stringBuilder.append(integer).append(" "));

            String outputLine = word + " occured in lines " + stringBuilder.toString() + "\n";

            try {
                fileWriter.write(outputLine);
            } catch (IOException e ) {
                throw new RuntimeException();
            }

        });

        fileWriter.close();
    }
}
