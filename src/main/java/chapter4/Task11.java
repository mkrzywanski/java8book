package chapter4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Task11 {
    private static Class<?> clazz = System.class;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Object out = clazz.getField("out")
                .get(null);

        Method m = out.getClass()
                .getDeclaredMethod("println", String.class);

        m.invoke(out, "Hello world");

    }
}
