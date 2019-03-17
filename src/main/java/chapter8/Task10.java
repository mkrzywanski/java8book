package chapter8;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task10 {

    public static void main(String[] args) {

        List<String> strings = Lists.newArrayList("one", "two", "three");

        getNLongestStrings(strings, 2)
                .forEach(System.out::println);

    }

    private static List<String> getNLongestStrings(List<String> strings, int n) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length).reversed()
                        .thenComparing(Comparator.naturalOrder()))
                .limit(n)
                .collect(Collectors.toList());
    }
}
