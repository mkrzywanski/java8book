package chapter5;

import java.util.Arrays;

public class Task10 {
    public static void main(String[] args) {
        System.out.println(factorial(10));

        Exception exception = new Exception("Message");
        exception.printStackTrace();
    }

    private static int factorial(int n) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        printStackTrace(stackTraceElements);

        if(n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    private static void printStackTrace(StackTraceElement[] stackTraceElements) {
        System.out.println("Stack trace : ");
        Arrays.stream(stackTraceElements).forEach(System.out::println);
    }
}
