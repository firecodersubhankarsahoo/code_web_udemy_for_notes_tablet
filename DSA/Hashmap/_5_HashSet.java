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



        //--------->>--------->>--------------- iterate  to traverse the set--------->>>----------------------->>>>>>--

        HashSet<String>set1=new HashSet<>();
        set1.add("delhi");
        set1.add("mumbai");
        set1.add("banglore");
        set1.add("chennai");


        // 1. Using Iterator(in java there is a built-in iterator class or interface which we can use to iterate over any collection)
        Iterator it=set1.iterator();
        while(it.hasNext()) {
            System.out.println(it.next() + " "); // Output: 1 2 (order may vary)

        }


        // 2. Using for-each loop
        for(String city:set1) {
            System.out.println(city);
        }
        // 3. Using forEach method with lambda expression
        set1.forEach(city -> System.out.println(city));




    }
}
