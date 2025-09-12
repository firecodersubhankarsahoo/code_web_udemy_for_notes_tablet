import java.util.*;

public class _7_TreeSet {
    public static void main(String[] args) {

        TreeSet<String>ts=new TreeSet<>();
        ts.add("delhi");
        ts.add("mumbai");
        ts.add("banglore");
        ts.add("chennai");
        ts.add("agra");
        ts.add("banglore"); // duplicate, will be ignored
        System.out.println(ts); // Output: [agra, banglore, chennai, delhi, mumbai] (sorted in ascending order)


        System.out.println(ts.size());    // Output: 5 . size of the set
        System.out.println(ts.isEmpty()); // Output: false . check if the set is empty or not
        System.out.println(ts.contains("mumbai")); // true
        System.out.println(ts.contains("pune")); // false
        ts.remove("agra");
        System.out.println(ts); // Output: [banglore, chennai, delhi, mumbai]

        // Iterate over elements
        for (String city : ts) {
            System.out.println(city);
        }

    }
}
