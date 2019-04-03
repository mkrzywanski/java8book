package chapter13;

import java.util.*;

public class Task5 {
    private static Set<String> possibleDisplayCurrencies = new HashSet<>();

    public static void main(String[] args) {

        Arrays.stream(Locale.getAvailableLocales())
                .forEach(locale -> Currency.getAvailableCurrencies()
                        .forEach(currency -> possibleDisplayCurrencies.add(currency.getDisplayName(locale)))
                );

        possibleDisplayCurrencies.forEach(System.out::println);
    }
}
