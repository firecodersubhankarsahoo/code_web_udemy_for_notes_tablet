import java.util.*;

// at the time of returning decrease the values in the array by 2

public class _1_Backtracking_in_arrays {
    public static void backtracking(int[] arr,int idx){
        if(idx== arr.length){
            return;
        }
        backtracking(arr,idx+1);
        arr[idx]=arr[idx]-2;    //backtracking step 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        backtracking(arr,0);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
}
