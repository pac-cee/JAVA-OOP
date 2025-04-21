import java.util.LinkedList;

public class HashTable {
    private static class Entry {
        int key, value;
        Entry(int key, int value) { this.key = key; this.value = value; }
    }
    private final int SIZE = 10;
    private LinkedList<Entry>[] table;

    public HashTable() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) table[i] = new LinkedList<>();
    }
    private int hash(int key) { return key % SIZE; }

    public void put(int key, int value) {
        int idx = hash(key);
        for (Entry e : table[idx]) {
            if (e.key == key) { e.value = value; return; }
        }
        table[idx].add(new Entry(key, value));
    }
    public Integer get(int key) {
        int idx = hash(key);
        for (Entry e : table[idx]) {
            if (e.key == key) return e.value;
        }
        return null;
    }
    public void remove(int key) {
        int idx = hash(key);
        table[idx].removeIf(e -> e.key == key);
    }
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + ": ");
            for (Entry e : table[i]) System.out.print("(" + e.key + "," + e.value + ") ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.put(1, 10); ht.put(11, 20); ht.put(2, 30);
        ht.display();
        System.out.println("Get 11: " + ht.get(11));
        ht.remove(1);
        ht.display();
    }
}
