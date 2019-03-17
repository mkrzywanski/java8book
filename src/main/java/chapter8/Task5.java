package chapter8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Task5 {

    private static final String WORD = "some";

    public static void main(String[] args) {

        IntStream intStream = letters("some");

        intStream.forEach(i -> System.out.println((char) i));

        System.out.println();

        Map<Integer, Character> indexToLetter = letters2(WORD);

        indexToLetter.forEach((index, character) -> System.out.println("Index " + index + " character " + character));

    }

    private static IntStream letters(String word) {
        return Arrays.stream(word.split("")).mapToInt(s -> s.charAt(0));
    }

    private static Map<Integer, Character> letters2(String word) {

        Map<Integer, Character> map = new HashMap<>();

        IntStream.iterate(0 , i -> i += 1)
                .limit(word.length())
                .forEach(i -> map.put(i, word.charAt(i)));

        return map;

    }

}
