package chapter12;

import java.time.LocalDateTime;

public class Task7 {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();

        TimeInterval meeting1 = new TimeInterval(now, now.plusHours(10));
        TimeInterval meeting2 = new TimeInterval(now.plusHours(5), now.plusHours(20));

        System.out.println(meeting1.overlaps(meeting2));
    }

    private static class TimeInterval {

        private LocalDateTime begin;
        private LocalDateTime end;

        TimeInterval(LocalDateTime begin, LocalDateTime end) {
            this.begin = begin;
            this.end = end;
        }

        boolean overlaps(TimeInterval second) {
            return (this.end.isAfter(second.begin) && this.begin.isBefore(second.begin)) ||
                    (this.begin.isBefore(second.begin) && this.end.isAfter(second.end)) ||
                    (this.begin.isBefore(second.end) && this.end.isAfter(second.end));
        }

    }
}
