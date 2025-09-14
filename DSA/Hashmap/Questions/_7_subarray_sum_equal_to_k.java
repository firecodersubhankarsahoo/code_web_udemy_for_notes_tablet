package Questions;

import java.util.*;

public class _7_subarray_sum_equal_to_k {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10,2,-2,-20,10};
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0,1); // for the case when sum itself is equal to k at some point in the array . So we put 0 sum with frequency 1 initially.this is necessary because if sum itself is equal to k then sum-k=0 and we have to count that subarray also
        // as we have to find the no of subarrays with sum equal to k so we have to count the frequency of sum-k in the map


        for(int j=0;j<arr.length;j++){
            sum+=arr[j];
            int tocheck=sum-k;                    // we have to check the frequency of sum-k in the map
            if(map.containsKey(tocheck)){        // if map contains sum-k then we add its frequency to the ans
                ans+=map.get(tocheck);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);          // we put the sum in the map with its frequency

        }
        System.out.println(ans);                                    // print the no of subarrays with sum equal to k


    }
}




/**
 ================== DRY RUN WITH VISUALS ==================

 arr = {10, 2, -2, -20, 10}, k = -10
 Initial:
 sum = 0, ans = 0
 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  1  |
 +-------+-----+

 -------------------------------------------------------
 Step j=0 → arr[0] = 10
 Array:   [10,   2,   -2,   -20,   10]
 ↑
 sum = 0+10 = 10
 toCheck = 20 → NOT in map
 ans = 0

 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  1  |
 |  10   |  1  |
 +-------+-----+

 -------------------------------------------------------
 Step j=1 → arr[1] = 2
 Array:   [10,   2,   -2,   -20,   10]
 ↑
 sum = 10+2 = 12
 toCheck = 22 → NOT in map
 ans = 0

 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  1  |
 |  10   |  1  |
 |  12   |  1  |
 +-------+-----+

 -------------------------------------------------------
 Step j=2 → arr[2] = -2
 Array:   [10,   2,   -2,   -20,   10]
 ↑
 sum = 12+(-2) = 10
 toCheck = 20 → NOT in map
 ans = 0

 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  1  |
 |  10   |  2  |
 |  12   |  1  |
 +-------+-----+

 -------------------------------------------------------
 Step j=3 → arr[3] = -20
 Array:   [10,   2,   -2,   -20,   10]
 ↑
 sum = 10+(-20) = -10
 toCheck = 0 → FOUND (freq=1)
 ans = 0+1 = 1

 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  1  |
 |  10   |  2  |
 |  12   |  1  |
 | -10   |  1  |
 +-------+-----+

 -------------------------------------------------------
 Step j=4 → arr[4] = 10
 Array:   [10,   2,   -2,   -20,   10]
 ↑
 sum = -10+10 = 0
 toCheck = 10 → FOUND (freq=2)
 ans = 1+2 = 3

 HashMap:
 +-------+-----+
 |  Key  | Freq|
 +-------+-----+
 |   0   |  2  |
 |  10   |  2  |
 |  12   |  1  |
 | -10   |  1  |
 +-------+-----+

 -------------------------------------------------------
 FINAL RESULT:
 ans = 3

 Subarrays with sum = -10:
 1. [10, 2, -2, -20]
 2. [2, -2, -20, 10]
 3. [-20, 10]


 **/
