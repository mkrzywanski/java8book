package chapter13;

import java.awt.*;
import java.util.*;

public class Task6 {

    private static Map<Currency, Set<String>> currencyToSymbols = new HashMap<>();

    public static void main(String[] args) {
        Arrays.stream(Locale.getAvailableLocales())
                .forEach(locale -> Currency.getAvailableCurrencies()
                        .forEach(currency -> {
                            String symbol = currency.getSymbol(locale);
                            currencyToSymbols.computeIfAbsent(currency, currency1 -> new HashSet<>()).add(symbol);
                        })
                );

        currencyToSymbols.entrySet()
                .stream()
                .filter(currencyListEntry -> currencyListEntry.getValue().size() >= 2)
                .forEach(currencySetEntry -> System.out.println(currencySetEntry.getKey().getDisplayName()));
    }
}
