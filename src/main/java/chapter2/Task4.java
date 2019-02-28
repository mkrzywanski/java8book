package chapter2;

import org.omg.CORBA.IntHolder;

public class Task4 {
    public static void main(String[] args) {
        IntHolder value1 = new IntHolder(2);
        IntHolder value2 = new IntHolder(3);

        swap(value1, value2);

        System.out.println("Value1 " + value1.value);
        System.out.println("Value2 " + value2.value);
    }

    private static void swap(IntHolder value1, IntHolder value2) {
        int temp = value1.value;
        value1.value = value2.value;
        value2.value = temp;
    }
}
