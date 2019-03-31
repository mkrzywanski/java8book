package chapter12;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Task12 {

    public static void main(String[] args) {

        ZonedDateTime now = ZonedDateTime.now();

        ZonedDateTime first = now.plusMinutes(30).withZoneSameInstant(ZoneId.of("CET"));
        ZonedDateTime second = now.plusHours(2).withZoneSameInstant(ZoneId.of("Etc/GMT-7"));
        ZonedDateTime third = now.plusMinutes(30).withZoneSameInstant(ZoneId.of("Etc/GMT-7"));
        ZonedDateTime fourth = now.plusHours(2).withZoneSameInstant(ZoneId.of("CET"));

        System.out.println("CET " + first + " " + beginsInLessThanHour(first));
        System.out.println("GMT-7 " + second + " " + beginsInLessThanHour(second));
        System.out.println("GMT-7 " + third + " " +beginsInLessThanHour(third));
        System.out.println("CET " + fourth + " " + beginsInLessThanHour(fourth));

    }

    private static boolean beginsInLessThanHour(ZonedDateTime meetingTime) {
        ZonedDateTime now = ZonedDateTime.now();
        return now.plusHours(1).isAfter(meetingTime) && meetingTime.isAfter(now);
    }

}
