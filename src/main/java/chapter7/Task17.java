package chapter7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task17 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);

        List safeList = Collections.checkedList(list, Integer.class);

        safeList.add(1.2);

    }
}
