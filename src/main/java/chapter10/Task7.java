package chapter10;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Task7 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();

        map.put("1", 1L);
        map.put("2", 2L);
        map.put("3", 3L);
        map.put("4", 4L);

        Map.Entry<String, Long> entry = map.reduceEntries(10L, (entry1, entry2) ->
                entry1.getValue() > entry2.getValue() ? entry1 : entry2
        );

        System.out.println(entry.getKey());
    }
}
