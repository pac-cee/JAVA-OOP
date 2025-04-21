import java.util.*;

public class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }
    private final int SIZE = 16;
    private List<Entry<K, V>>[] table;

    public CustomHashMap() {
        table = new List[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }
    private int hash(K key) { return (key.hashCode() & 0x7fffffff) % SIZE; }

    public void put(K key, V value) {
        int idx = hash(key);
        for (Entry<K, V> e : table[idx]) {
            if (e.key.equals(key)) { e.value = value; return; }
        }
        table[idx].add(new Entry<>(key, value));
    }
    public V get(K key) {
        int idx = hash(key);
        for (Entry<K, V> e : table[idx]) {
            if (e.key.equals(key)) return e.value;
        }
        return null;
    }
    public void remove(K key) {
        int idx = hash(key);
        table[idx].removeIf(e -> e.key.equals(key));
    }
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (Entry<K, V> e : table[i]) System.out.print("(" + e.key + "," + e.value + ") ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("apple", 1); map.put("banana", 2); map.put("orange", 3);
        map.display();
        System.out.println("Get 'banana': " + map.get("banana"));
        map.remove("apple");
        map.display();
    }
}
