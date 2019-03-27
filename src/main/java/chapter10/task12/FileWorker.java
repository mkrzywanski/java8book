package chapter10.task12;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class FileWorker implements Callable<Map<String, Integer>> {

    private File file;

    public FileWorker(File file) {
        this.file = file;
    }

    @Override
    public Map<String, Integer> call() throws Exception {

        Map<String, Integer> wordsToOccurencesMap = new HashMap<>();

        Files.lines(file.toPath())
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                .forEach(word -> wordsToOccurencesMap.merge(word, 1, Integer::sum));

        return wordsToOccurencesMap;

    }
}
