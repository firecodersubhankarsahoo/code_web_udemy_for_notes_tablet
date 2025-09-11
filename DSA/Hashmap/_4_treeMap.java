
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
        Scanner sc = new Scanner(System.in);


    }
}
