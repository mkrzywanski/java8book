package chapter6.task3;

import java.util.ArrayList;
import java.util.Optional;

class Table<K, V> {
    private ArrayList<Entry<K, V>> entries;

    Table() {
        entries = new ArrayList<>();
    }

    V get(K key) {
        Optional<Entry<K, V>> optional = entries.stream()
                .filter(kvEntry -> kvEntry.getKey().equals(key))
                .findFirst();

        if(optional.isPresent()) {
            return optional.get().getValue();
        } else {
            return null;
        }
    }

    V put(K key, V value) {
        for (Entry<K, V> currentEntry : entries) {
            if (currentEntry.getKey().equals(key)) {
                V val = currentEntry.getValue();
                currentEntry.setValue(value);
                return val;
            }
        }

        entries.add(new Entry<>(key, value));

        return null;
    }

    V remove(K key) {
        for (Entry<K, V> currentEntry : entries) {
            if (currentEntry.getKey().equals(key)) {
                V val = currentEntry.getValue();
                entries.remove(currentEntry);
                return val;
            }
        }
        return null;
    }

    int size() {
        return entries.size();
    }

}
