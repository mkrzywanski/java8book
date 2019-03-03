package chapter4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task12 {
    private static final String MESSAGE = "Hello world";
    private static Object out;
    private static Method method;

    static {
        try {

            out = System.class.getField("out")
                    .get(null);

            method = out.getClass()
                    .getDeclaredMethod("println", String.class);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        long simpleHelloworldInvocationTime = measureTimeInvocation(Task12::simpleHelloWorld);
        long reflectiveHelloworldInvocationTime = measureTimeInvocation(Task12::reflectiveHelloWorld);

        System.out.println("Simple Helloworld invocation time " + simpleHelloworldInvocationTime + " ms");
        System.out.println("Reflective Helloworld invocation time " + reflectiveHelloworldInvocationTime + " ms");

    }

    private static long measureTimeInvocation(Runnable method) {
        long startTime = System.currentTimeMillis();

        method.run();

        long after = System.currentTimeMillis();

        return after - startTime;
    }

    private static void simpleHelloWorld() {
        System.out.println(MESSAGE);
    }

    private static void reflectiveHelloWorld() {
        try {
            method.invoke(out, "Hello world");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
