package chapter6;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class Task15 {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3);
        List<String> result = map(numbers, String::valueOf);
        result.forEach(System.out::println);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        return list.stream()
                .map(function)
                .collect(toList());
    }
}
