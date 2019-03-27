package chapter10.task13;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class FileWorker implements Runnable {


    private ConcurrentMap<String, Integer> concurrentMap;
    private File file;

    public FileWorker(ConcurrentMap<String, Integer> concurrentMap, File file) {
        this.concurrentMap = concurrentMap;
        this.file = file;
    }

    @Override
    public void run() {
        try {
            Files.lines(file.toPath())
                    .map(line -> line.split(" "))
                    .flatMap(Arrays::stream)
                    .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                    .forEach(word -> concurrentMap.merge(word, 1, Integer::sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
