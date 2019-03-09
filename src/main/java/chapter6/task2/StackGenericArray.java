package chapter6.task2;

import java.util.function.IntFunction;
import java.util.stream.Stream;

public class StackGenericArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(2,5, Integer[]::new);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        Stream.iterate(-1, integer -> integer - 1).limit(10).forEach(stack::push);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("DONE");
    }

    private static class Stack<E> {
        private E[] elements;
        private int topIndex = -1;
        private int resizeFactor;
        private IntFunction<E[]> generator;

        private Stack(int resizeFactor, int initialSize, IntFunction<E[]> generator) {
            this.resizeFactor = resizeFactor;
            this.elements = generator.apply(initialSize);
            this.generator = generator;
        }

        private void push(E element) {
            if(topIndex >= elements.length - 1) {
                this.resize();
            }

            elements[++topIndex] = element;
        }

        private void resize() {
            int newLength = elements.length * resizeFactor;

            E[] newTab = generator.apply(newLength);

            System.arraycopy(elements, 0, newTab, 0, elements.length);

            this.topIndex = elements.length - 1;
            this.elements = newTab;
        }

        private E pop() {
            return elements[topIndex--];
        }

        private boolean isEmpty() {
            return topIndex == -1;
        }

    }
}
