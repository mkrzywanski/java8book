package chapter2.task16and17;

import java.util.stream.Stream;

public class Task16 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        queue.add(1);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.add(5);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        Stream.iterate(0, integer -> integer + 1)
                .limit(10)
                .forEach(queue::add);

        for(Integer i : queue) {
            System.out.println(i);
        }

    }
}
