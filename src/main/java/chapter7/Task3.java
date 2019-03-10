package chapter7;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class Task3 {

    public static void main(String[] args) {
        Set<Integer> firstSet = Sets.newHashSet(1, 2, 3);
        Set<Integer> secondSet = Sets.newHashSet(3, 4, 5);

        System.out.println("Sum");
        Set<Integer> sum = sum(firstSet, secondSet);

        sum.forEach(System.out::println);

        System.out.println("Intersection");
        Set<Integer> intersection = intercest(firstSet, secondSet);

        intersection.forEach(System.out::println);

        System.out.println("Difference");
        Set<Integer> difference = difference(firstSet, secondSet);

        difference.forEach(System.out::println);

    }

    private static <T> Set<T> sum(Set<T> firstSet, Set<T> secondSet) {
        Set<T> copy = new HashSet<>(firstSet);

        copy.addAll(secondSet);

        return copy;
    }

    private static <T> Set<T> intercest(Set<T> firstSet, Set<T> secondSet) {
        Set<T> copy = new HashSet<>(firstSet);

        copy.addAll(secondSet);
        copy.retainAll(secondSet);
        copy.retainAll(firstSet);

        return copy;
    }

    private static <T> Set<T> difference(Set<T> firstSet, Set<T> secondSet) {
        Set<T> sum = sum(firstSet, secondSet);
        Set<T> intersection = intercest(firstSet, secondSet);

        sum.removeAll(intersection);

        return sum;
    }
}
