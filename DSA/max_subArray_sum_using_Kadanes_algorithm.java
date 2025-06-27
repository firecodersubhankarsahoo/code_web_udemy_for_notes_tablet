

/*
    ✅ Kadane's Algorithm (O(n)) – Maximum Subarray Sum


    🔸 Idea:
        - Traverse the array and keep track of:
            ➤ currSum: sum of current subarray
            ➤ maxSum: max of all subarray sums seen so far
        - If currSum becomes negative, reset it to 0 // it is the main point of this Algorithm
        - maxSum is updated whenever currSum >maxSum.

    🔸 Works for both positive and negative numbers.
    🔸 Time Complexity: O(n)
*/

import javax.swing.text.html.CSS;
import java.util.*;
public class max_subArray_sum_using_Kadanes_algorithm {

    public static void kadanes(int[] arr) {
        int maxSum = Integer.MIN_VALUE; //-infinity  //MS  🔸 Tracks the maximum subarray sum so far
        int currSum = 0;                //CS 🔹 Tracks the current subarray sum

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];          // Add current element to the current sum
            if (currSum < 0) {
                currSum = 0;            // Reset to 0 if current sum is negative
            }
            maxSum = Math.max(currSum, maxSum); // Update maxSum if currentSum is larger
        }
        System.out.println("our max sub array sum is = " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        kadanes(arr);
    }
}

/*
     arr=   |-2 |-3 | 4 |-1 |-2 | 1 | 5 |-3 |
            |   |   |   |   |   |   |   |   |
       CS=  | 0 | 0 | 4 | 3 | 1 | 2 | 7 | 4 |
       MS=  | 0 | 0 | 4 | 4 | 4 | 4 | 7 | 7 |


       so maxi mum sum of subarray= 7

 */