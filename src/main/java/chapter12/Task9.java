package chapter12;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Task9 {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds()
                .stream()
                .map(ZoneId::of)
                .filter(zoneId -> {
                    ZoneOffset offset = zoneId.getRules().getOffset(LocalDateTime.now());
                    double hours = offset.getTotalSeconds() / (double) 3600;
                    return hours % 1 != 0;
                }).forEach(System.out::println);
    }
}
