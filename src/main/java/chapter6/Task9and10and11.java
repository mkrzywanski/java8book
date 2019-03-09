package chapter6;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class Task9and10and11 {

    public static void main(String[] args) {
        List<Integer> numbers = Lists.newArrayList(1, 2);
        Pair<Integer> pair = Arrays.get(numbers);

        System.out.println("Pair first " + pair.getFirst());
        System.out.println("Pair second " + pair.getSecond());

        System.out.println("Min " + Arrays.min(numbers));
        System.out.println("Max " + Arrays.max(numbers));

        MinMaxPair<Integer> minMaxPair = Arrays.minMax(numbers);
        System.out.println("Pair min " + minMaxPair.getMin());
        System.out.println("Pair max " + minMaxPair.getMax());
    }

    private static class Arrays {
        private static <E> Pair<E> get(List<? extends E> list) {
            if(list.size() < 2) {
                return null;
            }
            return new Pair<>(list.get(0), list.get(list.size() - 1));
        }

        private static <E extends Comparable<? super E>> E min(List<E> list) {
            return list.stream().sorted().findFirst().get();
        }

        private static <E extends Comparable<? super E>> E max(List<E> list) {
            return list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        }

        private static <E extends Comparable<? super E>> MinMaxPair<E> minMax(List<E> list) {
            E min = min(list);
            E max = max(list);

            return new MinMaxPair<>(min, max);

        }
    }


    private static class Pair<T> {
        private T first;
        private T second;

        Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        private T getFirst() {
            return first;
        }

        private T getSecond() {
            return second;
        }

    }

    private static class MinMaxPair<T> {
        private T min;
        private T max;

        private MinMaxPair(T min, T max) {
            this.min = min;
            this.max = max;
        }

        private T getMin() {
            return min;
        }

        private T getMax() {
            return max;
        }
    }
}
