package chapter2.task16and17;

import java.util.Iterator;

public class Queue<T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private Node currentNode = begin;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            Node node = currentNode;
            currentNode = node.next;
            return node.value;
        }
    }

    private class Node {
        private T value;
        private Node next;
    }

    private Node begin;
    private Node end;

    public void add(T value) {
        Node node = new Node();
        node.value = value;

        if(begin == null || end == null) {
            begin = node;
            end = node;
        }

        else {
            end.next = node;
            end = node;
        }
    }

    public T remove() {
        if(begin == null) {
            return null;
        } else {
            if(begin.next == null) {
                end = null;
            }

            Node node = begin;
            begin = begin.next;

            return node.value;

        }
    }
}
