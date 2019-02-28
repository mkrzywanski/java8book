package chapter3;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Task7 {

    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("v", "d", "wwe");

        luckySort(strings, Comparator.naturalOrder());

        strings.forEach(System.out::println);
    }

    static void luckySort(List<String> strings, Comparator<String> comparator) {
        while (!isInOrder(strings, comparator)) {
            Collections.shuffle(strings);
        }
    }

    static boolean isInOrder(List<String> strings, Comparator<String> comparator) {
        List<String> copy = new ArrayList<>(strings);
        copy.sort(comparator);
        return copy.equals(strings);
    }

}
