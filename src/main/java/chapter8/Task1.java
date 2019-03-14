package chapter8;

import com.google.common.collect.Lists;

import java.util.List;

public class Task1 {

    public static void main(String[] args) {

        List<String> words  = Lists.newArrayList("One", "Two", "Three", "Four", "Five", "Six");

        words.stream()
                .peek(System.out::println)
                .filter(s -> s.length() > 3)
                .limit(5)
                .close();
    }

}
