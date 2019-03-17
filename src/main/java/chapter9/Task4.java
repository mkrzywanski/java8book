package chapter9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task4 {

    private static final String FILE_PATH = "src/main/resources/war_and_peace";

    public static void main(String[] args) {

        System.out.println("Scanner test time " + measureInvocationTime(Task4::scannerTest) + " ms");
        System.out.println("BufferedReader test time " + measureInvocationTime(Task4::bufferedReaderTest) + " ms");

    }

    private static long measureInvocationTime(Runnable runnable) {

        long startTime = System.currentTimeMillis();

        runnable.run();

        return System.currentTimeMillis() - startTime;

    }

    public static void scannerTest() {
        try (Scanner scanner = new Scanner(new FileReader(FILE_PATH))){

            List<String> lines = new LinkedList<>();

            while (scanner.hasNext()) {
                lines.add(scanner.nextLine());
            }

            System.out.println("Lines number " + lines.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void bufferedReaderTest() {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {

            List<String> lines = bufferedReader.lines().collect(Collectors.toList());

            System.out.println("Lines number " + lines.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
