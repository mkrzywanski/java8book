package chapter12;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Task1 {
    public static void main(String[] args) {
        LocalDate programmerDay = LocalDate.now()
                .plus(255, ChronoUnit.DAYS);
        System.out.println(programmerDay);
    }
}
