package chapter9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task1 {

    private static final String FILE_PATH_FROM = "src/main/resources/war_and_peace";
    private static final String FILE_PATH_TO = "src/main/resources/war_and_peace_copy";


    public static void main(String[] args) throws IOException {
        solution2();
    }

    private static void solution1() {
        try (InputStream inputStream = Files.newInputStream(Paths.get(FILE_PATH_FROM));
             OutputStream outputStream = Files.newOutputStream(Paths.get(FILE_PATH_TO))) {

            int byteValue;

            while ((byteValue = inputStream.read()) != -1) {
                outputStream.write(byteValue);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void solution2() throws IOException {
        Files.copy(Paths.get(FILE_PATH_FROM), Paths.get(FILE_PATH_TO));
    }
}
