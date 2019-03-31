package chapter12;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Task11 {
    public static void main(String[] args) {
        ZonedDateTime flightStart = ZonedDateTime.of(LocalDateTime.of(2019, Month.JANUARY, 22, 14, 5), ZoneId.of("CET"));
        ZonedDateTime flightEnd = ZonedDateTime.of(LocalDateTime.of(2019, Month.JANUARY, 22, 16, 40), ZoneId.of("Etc/GMT-7"));
        System.out.println(ChronoUnit.HOURS.between(flightStart, flightEnd));
    }
}
