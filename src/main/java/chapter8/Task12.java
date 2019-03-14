package chapter8;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Task12 {

    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.iterate(0, integer -> integer)
                .limit(20);

        Stream<Integer> stream2 = Stream.iterate(1, integer -> integer)
                .limit(25);

        Stream<Integer> zippedStreams = zip(stream1, stream2);

        zippedStreams.forEach(System.out::println);

    }

    private static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {

        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        List<T> elements = new LinkedList<>();


        while (iterator1.hasNext() || iterator2.hasNext()) {
            handleElement(iterator1, elements);

            handleElement(iterator2, elements);
        }

        return elements.stream();

    }

    private static <T> void handleElement(Iterator<T> iterator1, List<T> elements) {
        if (iterator1.hasNext()) {
            elements.add(iterator1.next());
        } else {
            elements.add(null);
        }
    }
}
