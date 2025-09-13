package Questions;

import java.util.*;

public class _3_count_distinct_element {
    public static void main(String[] args) {
        int []arr={4,3,2,5,6,7,3,4,2,1};
        HashSet<Integer>lhs=new HashSet<>();    // we are using  hashset because it stores only distinct elements
        for(int i=0;i<arr.length;i++){
            lhs.add(arr[i]);
        }

        System.out.println("the no of distinct elements are: "+lhs.size());

    }
}
