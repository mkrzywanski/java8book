package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjusters;

public class Task6 {

    private static final int MAX_YEAR = 2000;

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1900, Month.JANUARY, 1);
        LocalDate fridayDate = localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.FRIDAY));

        while (fridayDate.getYear() < MAX_YEAR) {

            if(fridayDate.getDayOfMonth() == 13) {
                System.out.println(fridayDate);
            }

            fridayDate = fridayDate.plusDays(7);
        }

    }

}
