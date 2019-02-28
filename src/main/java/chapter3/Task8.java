package chapter3;

import java.util.stream.Stream;

public class Task8 {

    private static class Greeter implements Runnable {
        private int n;
        private String target;


        private Greeter(int n, String target) {
            this.n = n;
            this.target = target;
        }

        @Override
        public void run() {
            Stream.iterate(0, integer -> integer + 1)
                    .limit(n)
                    .forEach(integer -> System.out.println("Hello " + target));
        }
    }

    public static void main(String[] args) {
        Runnable greeter1 = new Greeter(10, "Michael");
        Runnable greeter2 = new Greeter(20, "Joe");

        new Thread(greeter1).start();
        new Thread(greeter2).start();
    }
}
