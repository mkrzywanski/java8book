package chapter7;

import java.util.List;
import java.util.RandomAccess;

public class Task5 {

    private static void swap(List<?> list, int i , int j) {
        swapHelper(list, i, j);
    }

    private static <T> void swapHelper(List<T> list, int i, int j) {
        if(list instanceof RandomAccess) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        } else {
            //TODO implement swaping for LinkedList
        }
    }

}
