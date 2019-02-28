package chapter3.task4and5;

public interface IntSequence {
    boolean hasNext();
    int next();

    static IntSequence of(int... values) {
        return new IntSequence() {

            int[] array = values;
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < array.length;
            }

            @Override
            public int next() {
                currentIndex++;
                return array[currentIndex - 1];
            }
        };
    }

    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public int next() {
                return value;
            }
        };
    }

    public static void main(String[] args) {
        IntSequence intSequence = IntSequence.of(1,2,3,4);
        while (intSequence.hasNext()) {
            System.out.println(intSequence.next());
        }

        IntSequence constantSequence = IntSequence.constant(1);
        while (constantSequence.hasNext()) {
            System.out.println(constantSequence.next());
        }
    }
}