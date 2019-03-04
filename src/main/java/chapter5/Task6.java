package chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task6 {
    private static final String PATH = "";

    public static void main(String[] args) {
    }

    private static void solutionA() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(PATH));
        } catch (IOException ex) {
            System.err.println("Error");
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void solutionB() {
        BufferedReader bufferedReader = null;
        try {
            try {
                bufferedReader = Files.newBufferedReader(Paths.get(PATH));
            } catch (IOException ex) {
                System.err.println("Error");
            }
            finally {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Error");
        }
    }

    private static void solutionC() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(PATH))) {

        } catch (IOException ex) {
            System.err.println("Error");
        }
    }
}
