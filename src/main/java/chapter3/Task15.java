package chapter3;

import java.util.Random;
import java.util.stream.Stream;

public class Task15 {
    private interface IntSequence {
        boolean hasNext();
        int next();
    }

    private static class RandomSequence implements IntSequence {
        private int low;
        private int high;
        private Random generator;

        private RandomSequence(int low, int high) {
            this.generator = new Random();
            this.low = low;
            this.high = high;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public int next() {
            return low + generator.nextInt(high - low + 1);
        }
    }

    public static void main(String[] args) {
        IntSequence intSequence = new RandomSequence(0, 10);

        Stream.iterate(0, integer -> integer + 1)
                .limit(10)
                .forEach(integer -> System.out.println(intSequence.next()));
    }
}
