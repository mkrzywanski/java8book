package chapter6;

public class Task7and8 {

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(1, 2);

        System.out.println("Pair first " + pair.first);
        System.out.println("Pair second " + pair.second);
        System.out.println("Max " + pair.max());
        System.out.println("Min " + pair.min());
    }

    private static class Pair<E extends Comparable<? super E>> {
        private E first;
        private E second;

        public Pair(E first, E second) {
            this.first = first;
            this.second = second;
        }

        private E getFirst() {
            return first;
        }

        private E getSecond() {
            return second;
        }

        private E max() {
            return first.compareTo(second) >= 0 ? first : second;
        }

        private E min() {
            return first.compareTo(second) >= 0 ? second : first;
        }
    }
}
