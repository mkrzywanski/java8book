package chapter4;

public class Task8 {
    public static void main(String[] args) {

        printClassInfo(String.class);
        printClassInfo(int[].class);
        printClassInfo(Inner.class);
        printClassInfo(int.class);

    }

    private class Inner {

    }

    private static void printClassInfo(Class<?> clazz) {

        System.out.println();
        System.out.println(clazz.getCanonicalName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getName());
        System.out.println(clazz.toString());
        System.out.println(clazz.toGenericString());

    }
}
