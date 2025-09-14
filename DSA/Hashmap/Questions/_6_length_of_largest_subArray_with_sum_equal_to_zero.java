package Questions;

import java.util.*;

// Question: Find the length of the largest subarray  length with sum equal to zero

public class _6_length_of_largest_subArray_with_sum_equal_to_zero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};              // input array
        HashMap<Integer, Integer> map = new HashMap<>();        // stores sum and its first index
        int mlength = 0;                                        // stores maximum length of subarray found
        int sum = 0;                                             // stores prefix sum

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];                          // calculate prefix sum step by step

            if (sum == 0) {
                // if prefix sum is 0 from start to current index
                // then length of subarray = j+1
                mlength = Math.max(mlength, j + 1);
            }

            if (map.containsKey(sum)) {
                // if same prefix sum was seen before,then the subarray b/w -->>  index(i) stored in map (with key as the cursum) and the current index(j) has sum 0
                int i = map.get(sum);                    // get first index where this sum appeared
                int len = j - i;                            // length of subarray
                mlength = Math.max(mlength, len);               // update max length
            } else {
                             // store the prefix sum with its index only once (first occurrence)
                map.put(sum, j);
            }
        }

        System.out.println("The length of largest subarray with sum = 0 is: " + mlength);
    }
}



// ------------------------------------Dry Run-----------------------------------

// arr = {15, -2, 2, -8, 1, 7, 10, 23}
// map = {}
// mlength = 0
// sum = 0
// j=0: sum=15, map={15:0}, mlength=0
// j=1: sum=13, map={15:0, 13:1
// j=2: sum=15, map={15:0, 13:1}, mlength=2 (subarray: [-2,2])
// j=3: sum=7, map={15:0, 13:1

// j=4: sum=8, map={15:0, 13:1, 7:3, 8:4}
// j=5: sum=15, map={15:0, 13:1, 7:3, 8:4}, mlength=5 (subarray: [-2,2,-8,1,7])
// j=6: sum=25, map={15:0, 13:1, 7:3, 8:4, 25:6}
// j=7: sum=48, map={15:0, 13:1, 7:3, 8:4, 25:6, 48:7}
// Final mlength=5
// Output: The length of largest subarray with sum = 0 is: 5









/*       --- ------------------To print the largest subarray also-------------------


  package Questions;

import java.util.*;

public class _6_length_of_largest_subArray_with_sum_equal_to_zero {
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        HashMap<Integer, Integer> map = new HashMap<>();
        int mlength = 0;
        int sum = 0;
        int start = -1, end = -1; // to store subarray boundaries

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];

            if (sum == 0) {
                // whole array from 0..j has sum=0
                if (mlength < j + 1) {
                    mlength = j + 1;
                    start = 0;
                    end = j;
                }
            }

            if (map.containsKey(sum)) {
                int i = map.get(sum);
                int len = j - i;
                if (len > mlength) {
                    mlength = len;
                    start = i + 1;
                    end = j;
                }
            } else {
                map.put(sum, j);
            }
        }

        System.out.println("The length of largest subarray with sum = 0 is: " + mlength);

        if (start != -1 && end != -1) {
            System.out.print("Largest subarray: ");
            for (int k = start; k <= end; k++) {
                System.out.print(arr[k] + " ");
            }
        }
    }
}
*/