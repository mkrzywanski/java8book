package chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {
    private static final String FILE_NAME = "src/main/resources/numbers";

    public static void main(String[] args) throws IOException {
        ArrayList<Double> numbers = readeNumbers(FILE_NAME);
        numbers.forEach(System.out::println);
    }

    private static ArrayList<Double> readeNumbers(String fileName) throws IOException {
        ArrayList<Double> numbers = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(fileName));

        lines.forEach(s -> {
                String[] stringNumbers = s.split(" ");
                Arrays.stream(stringNumbers)
                        .mapToDouble(Double::new)
                        .forEach(numbers::add);});

        return numbers;
    }
}
