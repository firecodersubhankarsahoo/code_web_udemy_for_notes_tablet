import java.util.*;


public class max_sub_array_sum_brute_fource_approach {

    public static  void subarray_max_sum(int[] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            int st=i;
            for(int j=i;j<arr.length;j++){
                int ed=j;
                int sum=0;
                for(int k=st;k<=ed;k++){
                    sum+=arr[k];
                }
                max=Math.max(sum,max);
            }
        }
        System.out.println("the max sum of subarrays is = "+max);

    }


    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        subarray_max_sum(arr);

    }
}
