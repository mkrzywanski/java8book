package chapter6;

import java.util.List;

public class Task6 {
    private static <T> void append1(List<T> source, List<? super T> target) {
        target.addAll(source);
    }

    private static <T> void append2(List<? extends T> source, List<T> target) {
        target.addAll(source);
    }
}
