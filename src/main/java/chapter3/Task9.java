package chapter3;

import java.util.Arrays;

public class Task9 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("run1");
        Runnable runnable2 = () -> System.out.println("run2");

        runTogether(runnable, runnable2);
        runInOrder(runnable, runnable2);
    }

    public static void runTogether(Runnable... tasks) {
        Arrays.stream(tasks)
                .forEach(runnable -> new Thread(runnable).start());
    }

    public static void runInOrder(Runnable... tasks) {
        Arrays.stream(tasks)
                .forEach(Runnable::run);
    }
}
