import java.util.*;

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
