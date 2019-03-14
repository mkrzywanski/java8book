package chapter8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task17 {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("A", "A", "A", "B", "B", "A", "A", "A", "C", "C", "C", "A", "A", "B", "B", "A");

        List<String> result = IntStream.range(0, strings.size())
                .filter(index -> index == 0 || !strings.get(index).equals(strings.get(index - 1)))
                .mapToObj(strings::get)
                .collect(Collectors.toList());

        result.forEach(System.out::print);
    }

}
