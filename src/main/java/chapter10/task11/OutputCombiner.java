package chapter10.task11;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class OutputCombiner implements Runnable {

    private BlockingQueue<Map<String, Integer>> mapBlockingQueue;
    private Map<String, Integer> resultMap;

    public OutputCombiner(BlockingQueue<Map<String, Integer>> mapBlockingQueue) {
        this.mapBlockingQueue = mapBlockingQueue;
        this.resultMap = new HashMap<>();
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            try {

                Map<String, Integer> wordsToOccurrencesMap = mapBlockingQueue.take();

                wordsToOccurrencesMap.forEach((s, integer) -> resultMap.merge(s, integer, Integer::sum));

                System.out.println("Current map : ");

                resultMap.forEach((word, occurences) -> {
                    System.out.println("Word " + word + " Occurences : " + occurences);

                });

            } catch (InterruptedException e) {
                System.out.println("OutputCombiner thread interrupted");
                Thread.currentThread().interrupt();
            }

        }

    }

}
