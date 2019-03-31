package chapter12;

import java.time.LocalDate;

public class Task2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2000, 2, 29).plusYears(1);
        System.out.println(localDate);
    }
}
