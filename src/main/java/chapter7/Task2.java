package chapter7;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("a", "b", "c");
        toUppercaseC(strings);
        strings.forEach(System.out::println);
    }

    private static void toUppercaseA(List<String> words) {
        Iterator<String> iterator = words.iterator();
        List<String> result = new LinkedList<>();

        while (iterator.hasNext()) {
            String news = iterator.next().toUpperCase();
            result.add(news);
        }

        words.clear();
        words.addAll(result);
    }

    private static void toUppercaseB(ArrayList<String> words) {
        List<String> result = new LinkedList<>();

        for (String cur : words) {
            result.add(cur.toUpperCase());
        }

        words.clear();
        words.addAll(result);
    }

    private static void toUppercaseC(List<String> words) {
        words.replaceAll(String::toUpperCase);
    }
}
