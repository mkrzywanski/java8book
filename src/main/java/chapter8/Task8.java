package chapter8;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task8 {

    private static List<Character> vowels = new LinkedList<>();

    static {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }

    public static void main(String[] args) {

        List<String> words = Lists.newArrayList("some", "EVACUATION", "REMUNERATION", "REGULATION");

        getWordsWithAtLeastNVowels(words, 5).forEach(System.out::println);

    }

    private static List<String> getWordsWithAtLeastNVowels(List<String> words, int n) {

        return words.stream()
                .filter(word -> {
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Arrays.stream(word.split(""))
                    .forEach(charAsString -> {
                        if(vowels.contains(charAsString.charAt(0)) || vowels.contains(charAsString.toLowerCase().charAt(0))) {
                            atomicInteger.incrementAndGet();
                        }
                    });
            return atomicInteger.get() >= n;
        }).collect(Collectors.toList());

    }
}
