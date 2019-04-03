package chapter13;

import java.util.Arrays;
import java.util.Locale;

public class Task2 {
    public static void main(String[] args) {
        Arrays.stream(Locale.getAvailableLocales()).forEach(System.out::println);
        //Locale.ITALY.getUnicodeLocaleType();
    }
}
