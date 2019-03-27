package chapter10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task1 {

    private static final String DIR_PATH = "src/main/resources/textFiles";

    public static void main(String[] args) throws IOException {

        String wordToBeFound = "world";

        List<Path> paths = getFilesContainingWord(wordToBeFound);

        paths.forEach(System.out::println);

    }

    private static List<Path> getFilesContainingWord(final String wordToBeFound) throws IOException {
        return Files.list(Paths.get(DIR_PATH))
                .parallel()
                .filter(path -> {
                    try {
                        return Files.lines(path)
                                .parallel()
                                .map(line -> line.split(" "))
                                .flatMap(Arrays::stream)
                                .map(word -> word.replaceAll("[^a-zA-Z0-9 ]", ""))
                                .anyMatch(s -> s.equals(wordToBeFound));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
