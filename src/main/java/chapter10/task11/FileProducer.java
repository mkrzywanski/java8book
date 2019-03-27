package chapter10.task11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class FileProducer implements Runnable {

    private static final String DIR_PATH = "src/main/resources/books";

    static final File POISON_PILL_FILE_Q = new File("poison");

    private BlockingQueue<File> fileBlockingQueue;

    FileProducer(BlockingQueue<File> fileBlockingQueue) {
        this.fileBlockingQueue = fileBlockingQueue;
    }

    @Override
    public void run() {
        try {

            Files.list(Paths.get(DIR_PATH))
                    .forEach(path -> fileBlockingQueue.add(path.toFile()));

            fileBlockingQueue.put(POISON_PILL_FILE_Q);

            System.out.println("File producer finished adding files to queue");

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("File producer thread interrupted");
        }
    }
}
