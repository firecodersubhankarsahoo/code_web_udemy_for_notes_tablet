import java.util.*;

// print the subarrays of an array.

public class _print_subarrays {

    public static  void subarray(int[] arr){
        int count=0;
        for(int i=0;i<arr.length;i++){
            int st=i;
            for(int j=i;j<arr.length;j++){
                int ed=j;
                for(int k=st;k<=ed;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println();
                count++;
            }
        }

    }


    public static void main(String[] args) {
    int[] arr={2,4,6,8,10};
    int n=arr.length;
    subarray(arr);
    int count=n*(n+1)/2;
    System.out.println("total no of sub array= "+count);
    }
}
