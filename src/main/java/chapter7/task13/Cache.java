package chapter7.task13;

import java.util.LinkedHashMap;
import java.util.Map;

public class Cache<K,V> extends LinkedHashMap<K, V> {

    private int maxSize;

    public Cache(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry entry) {
        return this.size() > maxSize;
    }

}
