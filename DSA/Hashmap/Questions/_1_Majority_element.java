package Questions;
// Given an array of size n, find the majority elements. The majority element are the element  that appears more than ⌊ n/3 ⌋ times.

import java.util.*;

public class _1_Majority_element {
    public static void findMajority(int[]arr){
        HashMap<Integer,Integer>map=new HashMap<>();

//        //Count frequencies of each item
//        for (int i=0;i<arr.length;i++){
//            int key=arr[i];
//            //value is the count of a particular number here
//            if(map.containsKey(key)){
//                map.put(key,map.get(key)+1);
//            }else {
//                map.put(key,1);
//            }
//
//        }


        //-----------------OR-----------OR------------- OR--------------OR-------------//
        //Count frequencies of each item
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //print the majority element
        for(int key: map.keySet()){
            if(map.get(key)>(arr.length/3)) {
                System.out.print(key+" , ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums1={1,3,2,5,1,3,1,5,1};
    findMajority(nums1);



    }
}
