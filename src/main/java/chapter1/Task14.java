package chapter1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Task14 {
    public static void main(String[] args) throws IOException {

        //int[][] array = loadDataFromStd();
        int[][] array = loadDataFromFile("src/main/resources/magicsquare");

        boolean isMagicSquare = isMagicSquare(array);

        System.out.println("Is magic square " + isMagicSquare);

    }

    private static int[][] loadDataFromStd() {
        System.out.print("Rows number = ");

        Scanner scanner = new Scanner(System.in);
        int rowsNumber = scanner.nextInt();
        scanner.nextLine();
        int[][] array = new int[rowsNumber][];

        Stream.iterate(0, integer -> integer + 1)
                .limit(rowsNumber)
                .forEach(index -> {
                    String line  = scanner.nextLine();
                    array[index] = Arrays.stream(line.split(" "))
                            .map(Integer::valueOf)
                            .mapToInt(i -> i)
                            .toArray();
                });

        return array;
    }

    private static int[][] loadDataFromFile(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        return lines.stream()
                .map(line -> Arrays.stream(line.split(" "))
                        .mapToInt(Integer::valueOf)
                        .toArray())
                .toArray(int[][]::new);
    }

    private static boolean isMagicSquare(int[][] array) {
        int sum = Arrays.stream(array[0]).sum();
        return checkColumns(array, sum) && checkRows(array, sum) && checkDiagonals(array, sum);

    }

    private static boolean checkDiagonals(int[][] array, int sum) {
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;

        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                if(i == j) {
                    firstDiagonalSum += array[i][j];
                }
                if(i + j == array[i].length) {
                    secondDiagonalSum += array[i][j];
                }
            }
        }

        return firstDiagonalSum == sum && secondDiagonalSum == sum;
    }

    private static boolean checkRows(int[][] array, int sum) {
        for(int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for(int j = 0; j < array[i].length; j++) {
                currentSum += array[i][j];
            }
            if(currentSum != sum) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkColumns(int[][] array, int sum) {
        for(int i = 0; i < array.length; i++) {
            int currentSum = 0;
            for(int j = 0; j < array[i].length; j++) {
                currentSum += array[j][i];
            }
            if(currentSum != sum) {
                return false;
            }
        }
        return true;
    }
}
