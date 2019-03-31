package chapter12;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class Task8 {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds()
                .stream()
                .map(ZoneId::of)
                .forEach(zoneId -> {
                    ZoneOffset offset = zoneId.getRules().getOffset(LocalDateTime.now());
                    System.out.println(zoneId.toString() + " " + offset.getId() + " " + offset.getTotalSeconds());
                });
    }
}
