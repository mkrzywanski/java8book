package chapter8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Task2 {

    private static final String FILE_PATH = "src/main/resources/countwords";
    private static final int THRESHOLD = 3;
    private static final int LIMIT = 10;

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(FILE_PATH));

        System.out.println("Ordinary stream " + measureTime(lines.stream()) + " ms");
        System.out.println("Parallel stream " + measureTime(lines.parallelStream()) + " ms");
    }

    private static long measureTime(Stream<String> stream) {
        long before = System.currentTimeMillis();

        stream.map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .filter(s -> s.length() > THRESHOLD)
                .limit(LIMIT)
                .close();

        return System.currentTimeMillis() - before;
    }
}
