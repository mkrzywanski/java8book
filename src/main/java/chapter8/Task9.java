package chapter8;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.OptionalDouble;

public class Task9 {

    public static void main(String[] args) {

        List<String> strings = Lists.newArrayList("One", "Two", "Three");

        OptionalDouble avgLength = getAverageStringLength(strings);

        if(avgLength.isPresent()) {
            System.out.println(avgLength.getAsDouble());
        } else {
            System.out.println("Strings list is empty");
        }

    }

    private static OptionalDouble getAverageStringLength(List<String> strings) {

        return strings.stream()
                .mapToInt(String::length)
                .average();

    }
}
