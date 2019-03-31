package chapter12;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.IntStream;

public class Task4 {

    private static final int YEAR = 2019;
    private static final Month MONTH = Month.JANUARY;


    public static void main(String[] args) {
        printCalendar(YEAR, MONTH.getValue());
    }

    private static void printCalendar(int year, int month) {

        LocalDate localDate = LocalDate.of(year, month, 1);

        int offset = localDate.getDayOfWeek().getValue() - 1;

        System.out.println("MON TUE WED THU FRI SAT SUN");

        IntStream.range(0, offset * 4).forEach(i -> System.out.print(" "));

        LocalDate currentDate = localDate;

        while (currentDate.getMonthValue() == month) {

            System.out.print(String.format("%02d", currentDate.getDayOfMonth()) + "  ");

            if(currentDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
                System.out.println();
            }

            currentDate = currentDate.plusDays(1);
        }

    }

}
