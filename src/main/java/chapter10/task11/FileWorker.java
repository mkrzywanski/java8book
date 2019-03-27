package chapter10.task11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class FileWorker implements Runnable {

    private BlockingQueue<File> fileBlockingQueue;
    private BlockingQueue<Map<String, Integer>> mapBlockingQueue;

    public FileWorker(BlockingQueue<File> blockingQueue, BlockingQueue<Map<String, Integer>> mapBlockingQueue) {
        this.fileBlockingQueue = blockingQueue;
        this.mapBlockingQueue = mapBlockingQueue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                File file = fileBlockingQueue.take();

                if(file == FileProducer.POISON_PILL_FILE_Q) {
                    System.out.println("Poison pill caught by file worker");
                    fileBlockingQueue.put(file);
                    return;
                }

                Map<String, Integer> wordsToOccurencesMap = new HashMap<>();

                Files.lines(file.toPath())
                        .map(s -> s.split(" "))
                        .flatMap(Arrays::stream)
                        .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                        .forEach(word -> wordsToOccurencesMap.merge(word, 1, Integer::sum));

                mapBlockingQueue.put(wordsToOccurencesMap);

            } catch (InterruptedException | IOException e) {
                Thread.currentThread().interrupt();
                System.out.println("File worker thread interrupted");
            }
        }
    }
}
