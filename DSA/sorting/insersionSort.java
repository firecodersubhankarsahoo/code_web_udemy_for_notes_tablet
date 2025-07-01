import java.util.*;

public class insersionSort {

    public static void Insersion(int[]arr){
        for (int i = 1; i < arr.length; i++) {
            int curr=arr[i];
            int prev=i-1;
            //finding out correct position to sort
            while (prev>=0 && arr[prev]>curr){
                arr[prev+1]=arr[prev];
                prev--;
            }
            //insert
            arr[prev+1]=curr;
        }


        //print array
        for(int x:arr){
            System.out.print(x+" ");
        }

    }
    public static void main(String[] args) {
        int[] arr={2,4,5,3,1};
        Insersion(arr);

    }
}
