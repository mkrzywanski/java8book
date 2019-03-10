package chapter7;

import java.util.HashMap;
import java.util.Map;

public class Task9 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        map.put("fourth", 4);
        map.put("fifth", 5);

        System.out.println("Existing keys");

        mergeA(map, "first", 1);
        System.out.println(map.get("first"));

        mergeB(map, "second", 1);
        System.out.println(map.get("second"));

        mergeC(map, "third", 1);
        System.out.println(map.get("third"));

        mergeD(map, "fourth", 1);
        System.out.println(map.get("fourth"));

        System.out.println("Not existing keys");

        mergeA(map, "first1", 1);
        System.out.println(map.get("first1"));

        mergeB(map, "second1", 1);
        System.out.println(map.get("second1"));

        mergeC(map, "third1", 1);
        System.out.println(map.get("third1"));

        mergeD(map, "fourth1", 1);
        System.out.println(map.get("fourth1"));

    }

    private static void mergeA(Map<String, Integer> map, String key, Integer valueToMerge) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + valueToMerge);
        } else {
            map.put(key, valueToMerge);
        }
    }

    private static void mergeB(Map<String, Integer> map, String key, Integer valueToMerge) {
        if(map.get(key) != null) {
            map.put(key, map.get(key) + valueToMerge);
        } else {
            map.put(key, valueToMerge);
        }
    }

    private static void mergeC(Map<String, Integer> map, String key, Integer valueToMerge) {
        Integer val = map.getOrDefault(key, 0);
        map.put(key, val + valueToMerge);
    }

    private static void mergeD(Map<String, Integer> map, String key, Integer valueToMerge) {
        Integer existingKeyValue = map.putIfAbsent(key, valueToMerge);

        if(existingKeyValue != null) {
            map.put(key, existingKeyValue + valueToMerge);
        }
    }

}
