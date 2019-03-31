package chapter12;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

public class Task3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate newDate = today.with(next(w -> w.getDayOfWeek().getValue() < 6));
        System.out.println(newDate);
    }

    private static TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(localDate -> {
            LocalDate newDate = localDate.plusDays(1);

            while (!predicate.test(newDate)) {
                newDate = newDate.plusDays(1);
            }

            return newDate;
        });
    }
}
