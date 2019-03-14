package chapter8;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task13 {

    public static void main(String[] args) {

        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4);
        List<Integer> numbers2 = Lists.newArrayList(1, 2, 3, 4);

        testMethod(Task13::reduce, 1, numbers, numbers2);
        testMethod(Task13::reduce2, 2, numbers, numbers2);
        testMethod(Task13::reduce3, 3, numbers, numbers2);
        testMethod(Task13::reduce4, 4, numbers, numbers2);

    }

    @SafeVarargs
    private static <T> void testMethod(Function<Stream<List<T>>, List<T>> function, int index, List<T>... elements) {
        Stream<List<T>> stream = Arrays.stream(elements);

        System.out.println("Reduce " + index);

        function.apply(stream).forEach(System.out::println);
    }

    private static <T> List<T> reduce(Stream<List<T>> stream) {
        return stream.flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private static <T> List<T> reduce2(Stream<List<T>> stream) {

        return stream.reduce((list, list2) -> {

            List<T> list1 = new ArrayList<>();
            list1.addAll(list);
            list1.addAll(list2);
            return list1;

        }).orElse(Collections.emptyList());
    }

    private static <T> List<T> reduce3(Stream<List<T>> stream) {
        return stream.reduce(new LinkedList<>(), (list, list2) -> {

            list.addAll(list2);
            return list;

        });
    }

    private static <T> List<T> reduce4(Stream<List<T>> stream) {
        return stream.reduce(new LinkedList<>(), (ts, list) -> {

            ts.addAll(list);
            return ts;

        }, (list, list2) -> {

            list.addAll(list2);
            return list;

        });
    }
}
