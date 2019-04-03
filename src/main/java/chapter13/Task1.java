package chapter13;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Task1 {

    public static void main(String[] args) {

        Locale franceLocale = Locale.FRANCE;
        Locale chinaLocale = Locale.CHINA;
        Locale thailandLocale = Locale.forLanguageTag("th-TH");

        LocalDateTime now = LocalDateTime.now();

        String chinaDate = formatDate(now, chinaLocale);
        String franceDate = formatDate(now, franceLocale);
        String thailandDate = formatDate(now, thailandLocale);

        System.out.println(chinaDate);
        System.out.println(franceDate);
        System.out.println(thailandDate);


    }

    private static String formatDate(LocalDateTime localDateTime, Locale locale) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        dateTimeFormatter = dateTimeFormatter.withLocale(locale);
        return dateTimeFormatter.format(localDateTime);
    }
}
