package chapter6;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class Task12 {
    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1,2,3);
        List<Integer> result = Lists.newArrayList();

        minMax(numbers, Comparator.naturalOrder(), result);

        result.forEach(System.out::println);
    }


    private static <T> void minMax(final List<T> elements, final Comparator<? super T> comparator, List<? super T> result) {
        T min = elements.stream()
                .sorted(comparator)
                .findFirst()
                .get();

        T max = elements.stream()
                .sorted(comparator.reversed())
                .findFirst()
                .get();

        result.add(min);
        result.add(max);
    }

    private static <T> void maxMin(final List<T> elements, final Comparator<? super T> comparator, List<? super T> result) {
        minMax(elements, comparator, result);
        swap(result, 0, 1);
    }

    private static <T> void swap(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}
