import java.util.*;


public class max_sub_array_sum_brute_fource_approach {

    public static  void subarray_max_sum(int[] arr){
        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            int st=i;
            for(int j=i;j<arr.length;j++){
                int ed=j;
                int currsum=0;
                for(int k=st;k<=ed;k++){
                    currsum+=arr[k];
                }
                maxSum=Math.max(currsum,maxSum);
            }
        }
        System.out.println("the max sum of subarrays is = "+max);

    }


    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        subarray_max_sum(arr);

    }
}
