package chapter5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1and2and3 {
    private static final String FILE_NAME = "src/main/resources/numbers";

    public static void main(String[] args) {
        try {
            ArrayList<Double> numbers = readeNumbers(FILE_NAME);

            numbers.forEach(System.out::println);

            double sum = sumOfValues(FILE_NAME);

            System.out.println("Sum = " + sum);

        } catch (IOException e) {
            System.out.println("File " + FILE_NAME + " was not found");
        }
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

    private static Double sumOfValues(String fileName) throws IOException {
        ArrayList<Double> numbers = readeNumbers(fileName);
        return numbers.stream()
                .mapToDouble(aDouble -> aDouble)
                .sum();
    }
}
