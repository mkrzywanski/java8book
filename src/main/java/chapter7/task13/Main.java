package chapter7.task13;

public class Main {
    public static void main(String[] args) {

        Cache<String, String> cache = new Cache<>(3);

        cache.put("1", "1");
        cache.put("2", "1");
        cache.put("3", "1");
        cache.put("4", "1");

        System.out.println(cache.size());

    }
}
