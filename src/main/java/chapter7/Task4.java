package chapter7;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(5, 10, 15, 20, 25, 30, 35, 40);

        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if(number % 10 == 0) {
                numbers.remove(number);
            }
        }

    }
}
