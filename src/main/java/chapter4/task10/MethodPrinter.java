package chapter4.task10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodPrinter {
    public static void main(String[] args) throws ReflectiveOperationException {
        Class<?> clazz = int[].class;

        int methodCounter = 0;

        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(
                    Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getCanonicalName() + " " +
                    method.getName() +
                    Arrays.toString(method.getParameters()));
                methodCounter++;
            }
            clazz = clazz.getSuperclass();
        }

        System.out.println("Methods count " + methodCounter);
    }
}
