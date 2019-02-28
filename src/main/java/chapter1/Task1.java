package chapter1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Input number : ");

        Scanner scanner = new Scanner(System.in);
        Integer number = scanner.nextInt();

        System.out.println("Binary = " + Integer.toBinaryString(number));
        System.out.println("Octal = " + Integer.toOctalString(number));
        System.out.println("Hexadecimal = " + Integer.toHexString(number));

        Double reverseNumber = 1 / (number * 1.0);
        System.out.println("Reversed number = " + reverseNumber);
        System.out.println("Hexadecimal reversed number = " + Double.toHexString(reverseNumber));
    }
}
