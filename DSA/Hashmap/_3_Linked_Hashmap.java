import java.util.*;

/*

>>>>>>>> LinkedHashMap Overview <<<<<<<<

✔ LinkedHashMap is similar to HashMap but it maintains the **insertion order**
  of keys (or access order if configured).
  it stores the element in the order they were added. and when we iterate over the map,
  it returns the elements in the order they were inserted.

✔ Time Complexity: same as HashMap
   - get()    → O(1) average case
   - put()    → O(1) average case
   - remove() → O(1) average case
  Because it is implemented as a **Hash table + Doubly Linked List**
  (the linked list maintains the order of elements).


* */


public class _3_Linked_Hashmap {
    public static void main(String[] args) {
        // LinkedHashMap maintains insertion order
        LinkedHashMap<String, Integer> linkedMap = new LinkedHashMap<>();

        // Insert entries
        linkedMap.put("A", 1);
        linkedMap.put("B", 2);
        linkedMap.put("C", 3);

        // Display entries (in insertion order)
        System.out.println("LinkedHashMap Entries: " + linkedMap);
        // Output: {A=1, B=2, C=3}  the output is in the  order of insertion but if it were a regular HashMap, order would be unpredictable

        // Access an entry(value for a key)
        System.out.println("Value for B: " + linkedMap.get("B")); // 2

        // Remove an entry(key-value pair)
        linkedMap.remove("A");
        System.out.println("After removing A: " + linkedMap);

        // Iterate over entries
        System.out.println("Iterating over LinkedHashMap:");
        for (Map.Entry<String, Integer> entry : linkedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
