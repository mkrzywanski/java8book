package chapter2;

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt(); // Modifies internal scanner position - modifying method

        Random random = new Random();
        random.nextInt(); // Does not modify object internal properties - accessing method
    }
}
