package chapter1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer firstNumber = scanner.nextInt();
        Integer secondNumber = scanner.nextInt();
        Integer thirdNumber = scanner.nextInt();

        Integer maxResult = Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
        System.out.println("Max = " + maxResult);
    }
}
