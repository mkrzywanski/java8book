package chapter12;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Task10 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.of(2019, Month.JANUARY, 22, 3, 5), ZoneId.of("Etc/GMT-7"))
                .plusHours(10)
                .plusMinutes(50)
                .withZoneSameInstant(ZoneId.of("CET"));
        System.out.println(zonedDateTime);
    }
}
