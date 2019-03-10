package chapter7;

import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Task14 {

    public static void main(String[] args) {

        List<Integer> unmodifiableList = getUnmodifiableList(10);

        unmodifiableList.add(1);


    }

    private static List<Integer> getUnmodifiableList(int n) {
        return Stream.iterate(0, t -> t + 1)
                .limit(n)
                .collect(collectingAndThen(Collectors.toList(), ImmutableList::copyOf));
    }

}
