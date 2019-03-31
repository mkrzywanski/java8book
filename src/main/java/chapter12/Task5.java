package chapter12;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Task5 {

    public static void main(String[] args) {

        LocalDate myDateOfBirth = LocalDate.of(1994, Month.DECEMBER, 15);
        LocalDate now = LocalDate.now();

        long days = ChronoUnit.DAYS.between(myDateOfBirth, now);

        System.out.println("Days since my birthday " + days);

    }

}
