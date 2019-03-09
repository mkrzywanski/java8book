package chapter6;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);

        System.out.println(stack.isEmpty());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static class Stack<T> {
        //LinkedList would be better here
        private List<T> list = new ArrayList<>();

        void push(T element) {
            list.add(element);
        }

        T pop() {
            if(list.size() > 0) {
                return list.remove(list.size() - 1);
            } else {
                return null;
            }
        }

        boolean isEmpty() {
            return list.size() == 0;
        }
    }
}
