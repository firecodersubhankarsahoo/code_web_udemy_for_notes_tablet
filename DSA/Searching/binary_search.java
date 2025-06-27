import java.util.*;

// binary search is always applied on sorted arrays
/* LOGIC:-
    1. take "start" and "end" pointer on index 0 and last index

    2. find "mid"  =(start+end)/2        //middle value

    3. compare "mid"  with the "key"(the value that need to search)

        a. if mid==key return index( key found)

        b. if key<mid ,then check in 1st half of array(start to mid)
                   now assign start=start ,end=mid-1
                   and then again perform step 1,2,3 .
                   do the same process until you find the element or a single sized array is remained (means element not present)

        c. if key>mid, then check on 2nd half .
                   start=mid+1;end=end;
                   and then again perform step 1,2,3 .
                    do the same process until you find the element or  a single sized array is remained(means element not present)
 */
public class binary_search {

    public  static int search(int[] arr,int key){
        int st=0;
        int ed=arr.length-1;
        while(st<=ed){
            int mid=(st+ed)/2;
            if(arr[mid]==key){
                return mid;
            }
            if (arr[mid]>key) {
                ed=mid-1;
            }else {
                st=mid+1;
            }

        }
        return -1;
    }





    public static void main(String[] args) {
        int[] arr={2,4,5,6,8,9,56,57,67,78}; //sorted array
        Arrays.sort(arr);
        int key=67;
        int x=search(arr,key);
        if(x==-1){
            System.out.println("key not found");
        }else {
            System.out.println("key is at index "+x);
        }


    }
}
