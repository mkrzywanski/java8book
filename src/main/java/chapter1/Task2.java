package chapter1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Degrees : ");
        Integer degrees = scanner.nextInt();
        Integer output = degrees % 360;
        System.out.println(Math.abs(output));
    }
}
