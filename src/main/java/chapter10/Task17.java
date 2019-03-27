package chapter10;

import chapter10.Task16;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Task17 {
    public static Long counter = 0L;

    private static final String DIR_PATH = "src/main/resources";

    public static void main(String[] args) throws IOException {
        List<File> files = getFiles(new File(DIR_PATH));

        List<Thread> threads = new LinkedList<>();

        files.forEach(file -> threads.add(new Thread(new FileWorker(file))));

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                thread.interrupt();
            }
        }

        System.out.println(counter);
    }

    private static List<File> getFiles(File file) throws IOException {
        if(!file.isDirectory()) {
            return new LinkedList<>();
        }

        List<File> collect = Files.list(file.toPath())
                .map(Path::toFile)
                .collect(Collectors.toList());

        List<File> result = new LinkedList<>();

        for(File file1 : collect) {
            if(file1.isDirectory()) {
                result.addAll(getFiles(file1));
            } else {
                result.add(file1);
            }
        }

        return result;

    }

    private static class FileWorker implements Runnable {

        private File file;

        private static Lock lock = new ReentrantLock();

        FileWorker(File file) {
            this.file = file;
        }

        @Override
        public void run() {
            try {
                Long wordsCount = Files.lines(file.toPath())
                        .map(line -> line.split(" "))
                        .flatMap(Arrays::stream)
                        .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                        .count();
                Thread.yield();
                lock.lock();
                counter += wordsCount;
                lock.unlock();
                Thread.sleep(10);

            } catch (IOException e) {
                System.out.println("Cannot read file " + file.getName());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
