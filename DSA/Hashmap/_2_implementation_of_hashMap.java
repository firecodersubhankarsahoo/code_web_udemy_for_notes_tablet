import java.util.*;

// ✅ Generic HashMap Implementation
class MyHashMap<K, V> {

    // Node class represents each entry (key-value pair)
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;  // for linked list (to handle collisions)

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 16;   // initial capacity of bucket array
    private float loadFactor = 0.75f; // threshold to trigger rehashing
    private int size = 0;        // number of key-value pairs
    private Node<K, V>[] table;  // array of linked lists (buckets)

    // Constructor → initialize the table
    public MyHashMap() {
        table = new Node[capacity];
    }

    // Hash function → maps key to a valid index in the table
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert or Update key-value pair
    public void put(K key, V value) {
        int index = hash(key);       // find index using hash function
        Node<K, V> head = table[index];

        // Search if key already exists in this bucket
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;  // update value if key found
                return;
            }
            head = head.next;
        }

        // If key not found → insert new node at head of the linked list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = table[index];
        table[index] = newNode;
        size++;  // increase size of HashMap

        // ✅ Check if rehashing is needed
        if ((1.0 * size) / capacity >= loadFactor) {
            rehash();
        }
    }

    // Retrieve value for a given key
    public V get(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];

        // Traverse linked list at that index
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;   // return value if key found
            }
            head = head.next;
        }
        return null;  // key not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> head = table[index];
        Node<K, V> prev = null;

        // Traverse linked list in that bucket
        while (head != null) {
            if (head.key.equals(key)) {
                // If first node → update table[index]
                if (prev == null) {
                    table[index] = head.next;
                } else {
                    prev.next = head.next;  // unlink node
                }
                size--;  // decrease size after removal
                return;  // key removed
            }
            prev = head;
            head = head.next;
        }
    }

    // Check if key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // ✅ Rehashing: done when load factor > threshold
    // Steps:
    // 1. Double the capacity of the bucket array.
    // 2. Create a new empty table with updated capacity.
    // 3. Re-insert all old key-value pairs into new table (recompute hash).
    private void rehash() {
        System.out.println("⚡ Rehashing triggered... Capacity doubled!");

        Node<K, V>[] oldTable = table;
        capacity = 2 * capacity;     // double capacity
        table = new Node[capacity];  // new bucket array
        size = 0;                    // reset size (will be updated by put)

        // Re-insert all old entries into new table
        for (Node<K, V> headNode : oldTable) {
            while (headNode != null) {
                put(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    // Utility method: returns size of HashMap
    public int size() {
        return size;
    }
}

// ✅ Driver class
public class _2_implementation_of_hashMap  {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Insert entries
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Retrieve values
        System.out.println("Value for A: " + map.get("A")); // 1
        System.out.println("Value for B: " + map.get("B")); // 2
        System.out.println("Contains C? " + map.containsKey("C")); // true

        // Remove key
        map.remove("B");
        System.out.println("Value for B (after remove): " + map.get("B")); // null

        // Trigger rehashing by inserting many values
        for (int i = 1; i <= 20; i++) {
            map.put("Key" + i, i);
        }

        System.out.println("Final Size: " + map.size());
    }
}






/*
📌 Rehashing in HashMap
------------------------
- HashMap uses an array of "buckets" to store key-value pairs.
- Each bucket can hold multiple nodes using linked lists (or trees in real Java).
- When too many keys are added → collisions increase → operations become slower.

✔️ To solve this, we use "rehashing":
    1. Create a new bucket array with double the capacity.
    2. Recalculate hash(index) for every existing key (since capacity changed).
    3. Move all key-value pairs into the new table.

⚡ When is rehashing done?
    - In Java's HashMap → when "Load Factor" exceeds 0.75.
    - Load Factor = number_of_entries / capacity
    - Example: capacity = 16, entries = 12 → load factor = 12/16 = 0.75 → time to rehash.

✔️ Effect:
    - Keeps linked lists short.
    - Ensures average O(1) performance for put/get/remove.
*/
