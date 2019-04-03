package chapter13;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Task3 {
    public static void main(String[] args) {
        Locale locale = Locale.US;
        locale.getUnicodeLocaleAttributes().forEach(System.out::println);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        //dateTimeFormatter.withLocale(locale).getResol
    }
}
