package chapter1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short first = (short) scanner.nextInt();
        short second = (short) scanner.nextInt();

        int sum = first + second;
        int difference = first - second;
        int division = first / second;
        int multiplication = first * second;

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
        System.out.println("Division = " + division);
        System.out.println("Multiplication = " + multiplication);
    }
}
