package chapter3;

import java.util.Arrays;

public class Task13 {
    public static void main(String[] args) {
        Runnable runnable1 = () -> System.out.println("runnable1");
        Runnable runnable2 = () -> System.out.println("runnable2");

        Runnable singleRunnable = asSingleRunnable(runnable1, runnable2);

        new Thread(singleRunnable).start();
    }

    private static Runnable asSingleRunnable(final Runnable... runnables) {
        return () -> Arrays.stream(runnables).forEach(Runnable::run);
    }
}
