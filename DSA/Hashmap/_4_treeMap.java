
import java.util.*;
/*
✔ TreeMap is similar to HashMap but it maintains a **sorted order of keys**
  based on their **natural ordering** or a specified **Comparator**.

✔ Time Complexity:
   - get()    → O(log n)
   - put()    → O(log n)
   - remove() → O(log n)
  Because it is implemented as a **Red-Black Tree** (self-balancing BST).



>>>>>>> the keys of treemap are sorted in ascending order by default.
example:
    TreeMap<Integer, String> map = new TreeMap<>();
    map.put(3, "Three");
    map.put(1, "One");
    map.put(2, "Two");
    System.out.println(map); // Output: {1=One, 2=Two, 3=Three}
        In this example, the keys (1, 2, 3) are sorted in ascending order by default.


        However, you can provide a custom comparator to sort the keys in a different order.
        For example, you can sort the keys in descending order by using Collections.reverseOrder() as
        the comparator when creating the TreeMap.

                👉 You can provide a **custom comparator** to change order.
                 Example:
                    TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
                 ✅ This will sort the keys in **descending order** instead of ascending.
                   example:
                    TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
                    map.put(3, "Three");
                    map.put(1, "One");
                    map.put(2, "Two");
                    System.out.println(map); // Output: {3=Three, 2=Two, 1=One}

                    
                    In this example, the keys (3, 2, 1) are sorted in descending order because we provided
                    Collections.reverseOrder() as the comparator when creating the TreeMap.



* */



public class _4_treeMap {
    public static void main(String[] args) {

        TreeMap<Integer, String> map = new TreeMap<>();

        // Insert entries
        map.put(3, "Three");
        map.put(1, "One");
        map.put(2, "Two");

        // Display entries (sorted by keys)
        System.out.println("TreeMap Entries: " + map); // Output: {1=One, 2=Two, 3=Three}

        // Access an entry(value for a key)
        System.out.println("Value for key 2: " + map.get(2)); // Two

        // Remove an entry(key-value pair)
        map.remove(1);
        System.out.println("After removing key 1: " + map); // Output: {2=Two, 3=Three}


        // Iterate over entries
        System.out.println("Iterating over TreeMap:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Demonstrating custom comparator (descending order)
        TreeMap<Integer, String> descMap = new TreeMap<>(Collections.reverseOrder());
        descMap.put(3, "Three");
        descMap.put(1, "One");
        descMap.put(2, "Two");
        System.out.println("TreeMap with custom comparator (descending order): " + descMap); // Output: {3=Three, 2=Two, 1=One}




    }
}
