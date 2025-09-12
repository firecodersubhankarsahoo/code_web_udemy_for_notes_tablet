import java.util.*;

public class _6_Linked_HashSet {
    public static void main(String[] args) {



        HashSet<String> set=new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("orange");
        set.add("banana"); // duplicate, will be ignored
        System.out.println(set); // Output: [banana, orange, apple] (will print in any order as HashSet does not maintain order)



        //------------------->>--------------- LinkedHashSet ------------------->>>----------------------->>>>>>--

        // LinkedHashSet maintains insertion order
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        // Insert elements
        lhs.add("Apple");
        lhs.add("Banana");
        lhs.add("Orange");
        lhs.add("Banana"); // Duplicate, will be ignored

        // Display elements (in insertion order)
        System.out.println("LinkedHashSet Elements: " + lhs);
         // Output: [Apple, Banana, Orange]  the output is in the  order of insertion but if it were a regular HashSet, order would be unpredictable

        // Check if an element exists
        System.out.println("Contains Banana: " + lhs.contains("Banana")); // true
        System.out.println("Contains Grape: " + lhs.contains("Grape")); // false

        // Remove an element
        lhs.remove("Apple");
        System.out.println("After removing Apple: " + lhs); // Output: [Banana, Orange]

        // Iterate over elements
        System.out.println("Iterating over LinkedHashSet:");
        for (String fruit : lhs) {
            System.out.println(fruit);
        }

            

    }
}
