import java.util.*;
public class prefix_sum_to_find_the_max_subarray_sum {

    public static  void subarray_max_sum(int[] arr){
        int[] prefix=new int[arr.length];
        //calculate prefix array
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefix[i]=prefix[i-1]+arr[i];
        }
        int maxSum=0;
        for(int i=0;i<arr.length;i++){
            int st=i;
            for(int j=i;j<arr.length;j++){
                int ed=j;
                int sum=0;
                if(st==0){
                    sum=prefix[ed];//When the subarray starts from index 0, the sum is directly the prefix at "ed"
                }else {
                    sum = prefix[ed] - prefix[st - 1]; // formula to find the sum using the prefix array
                }
                maxSum=Math.max(sum,maxSum);
            }
        }
        System.out.println("the max sum of subarrays is = "+max);
    }
    public static void main(String[] args) {
        int[] arr={2,4,6,8,10};
        subarray_max_sum(arr);
    }
}
