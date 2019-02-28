package chapter1;

import java.util.Arrays;
import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        System.out.print("Text : ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splittedLine = line.split(" ");
        Arrays.stream(splittedLine).forEach(System.out::println);
    }
}
