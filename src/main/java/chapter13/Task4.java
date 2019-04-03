package chapter13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Task4 {

    private static Set<String> possibleDisplayLanguages = new HashSet<>();

    public static void main(String[] args) {
        Arrays.stream(Locale.getAvailableLocales())
                .forEach(locale -> Arrays.stream(Locale.getAvailableLocales())
                        .forEach(locale1 -> possibleDisplayLanguages.add(locale.getDisplayLanguage(locale1)))
                );

        possibleDisplayLanguages.forEach(System.out::println);
    }
}
