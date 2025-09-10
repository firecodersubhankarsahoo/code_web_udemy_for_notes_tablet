import java.util.*;

public class _1_operations_in_hashMap {
    public static void main(String[] args) {
        HashMap<String,Integer> hm=new HashMap<>();
        hm.put("India", 120);
        hm.put("USA", 60);
        hm.put("China", 150);
        System.out.println(hm);
        // if we put the same key again it will update the value
        hm.put("India", 130);
        System.out.println(hm);

        //to get the value of a key
        int value=hm.get("India");
        System.out.println(value);

        //to check if a key is present or not in the hashmap
        boolean isPresent=hm.containsKey("India");
        System.out.println(isPresent);                  // if the key is present it will return true
        System.out.println(hm.containsKey("Pak"));        // if the key is not present it will return false


        //to remove a key-value pair from the hashmap
        System.out.println(hm.remove("USA"));
        System.out.println(hm);

        //to get the size of the hashmap
        System.out.println(hm.size());



        //to iterate over the hashmap
        for(String key:hm.keySet()){
            System.out.println(key+" "+hm.get(key));
        }

    }
}
