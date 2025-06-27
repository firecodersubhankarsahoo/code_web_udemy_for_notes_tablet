import java.util.*;

public class linear_search {


    public  static int search(int [] arr,int key){
        for (int i=0;i<arr.length;i++){
            if(arr[i]==key){
                return  i;
            }
        }
        return -1;// number not  found
    }
    public static void main(String[] args) {
        int[] arr={2,5,3,6,33,8,7,9};
        int key=33;
        int x=search(arr,key);
        if(x==-1){
            System.out.println("key not found");
        }else {
            System.out.println("key is at index "+x);
        }
    }
}

//time complexity =O(n)