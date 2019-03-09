package chapter6.task4;

import java.util.ArrayList;
import java.util.Optional;

public class Table<K, V> {
    private ArrayList<Entry> entries;

    public Table() {
        entries = new ArrayList<>();
    }

    public V get(K key) {
        Optional<Entry> optional = entries.stream()
                .filter(kvEntry -> kvEntry.getKey().equals(key))
                .findFirst();

        if(optional.isPresent()) {
            return optional.get().getValue();
        } else {
            return null;
        }
    }

    public V put(K key, V value) {
        for (Entry currentEntry : entries) {
            if (currentEntry.getKey().equals(key)) {
                V val = currentEntry.getValue();
                currentEntry.setValue(value);
                return val;
            }
        }

        entries.add(new Entry(key, value));

        return null;
    }

    public V remove(K key) {
        for (Entry currentEntry : entries) {
            if (currentEntry.getKey().equals(key)) {
                V val = currentEntry.getValue();
                entries.remove(currentEntry);
                return val;
            }
        }
        return null;
    }

    public int size() {
        return entries.size();
    }

    public class Entry {
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
            if (!(o.getClass().equals(Entry.class))) return false;

            Entry entry = (Entry) o;

            if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
            return value != null ? value.equals(entry.value) : entry.value == null;
        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }
    }

}
