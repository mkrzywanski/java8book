package chapter6.task3;

public class Entry<K,V> {
    private K key;
    private V value;

    Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry<?, ?> entry = (Entry<?, ?>) o;

        return (key != null ? key.equals(entry.key) : entry.key == null) && (value != null ? value.equals(entry.value) : entry.value == null);
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
