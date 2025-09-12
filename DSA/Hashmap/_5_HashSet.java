import java.util.*;

public class _5_HashSet {
    public static void main(String[] args) {
        HashSet<Integer>set=new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(2); // duplicate, will be ignored
        set.add(1); // duplicate, will be ignored
        System.out.println(set); // Output: [1, 2, 3] (order may vary as HashSet does not maintain order)


        System.out.println(set.size());    // Output: 3 . size of the set

        System.out.println(set.isEmpty()); // Output: false . check if the set is empty or not

        // Check if an element exists
        System.out.println(set.contains(2)); // true
        System.out.println(set.contains(5)); // false

        // Remove an element
        set.remove(3);
        System.out.println(set); // Output: [1, 2]





    }
}
