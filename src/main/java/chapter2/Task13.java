package chapter2;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Task13 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("src/main/resources/insurance.csv");
        CSVReader csvReader = new CSVReader(fileReader);

        csvReader.readAll()
                .forEach(strings -> {
                    Arrays.stream(strings)
                        .forEach(s -> System.out.print(s + " "));
                    System.out.println();
                });
    }
}
