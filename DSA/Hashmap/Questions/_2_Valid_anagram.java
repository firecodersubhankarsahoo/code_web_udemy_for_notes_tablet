package Questions;
import java.util.*;
public class _2_Valid_anagram {

    // Function to check if two strings are valid anagrams
    public static boolean isValid(String s, String t) {          // Step 1: If lengths are different, they can't be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {               // Step 2: Store frequency of each character in first string
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {         // Step 3: Check second string characters against the map
            char ch = t.charAt(i);
            if (map.containsKey(ch)) {              // If character exists, reduce its frequency
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {          // Remove the entry if frequency becomes 0
                    map.remove(ch);
                }
            } else {
                return false;   // If character not found in hashmap, not an anagram
            }
        }

        return map.isEmpty();         // Step 4: If map is empty, all characters matched so anagram else not anagram
        
    }
    public static void main(String[] args) {
        String s = "heart";
        String t = "earth";
        if (isValid(s, t)) {
            System.out.println("valid anagram");
        } else {
            System.out.println("not a valid anagram");
        }
    }
}
