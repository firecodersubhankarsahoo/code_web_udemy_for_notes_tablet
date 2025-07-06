import java.util.*;

public class _8_last_occurence_of_an_element_in_an_array {

    public static int findIdx(int[]arr,int tar,int i){
      int isfound=findIdx(arr,tar,i+1);  //look forward first

      if(isfound==-1 && arr[i]==tar){  //if element not found in forward array then check with self
          return i;
      }else {
          return -1;  //Return -1 as the element is not found in forward array and not matched with self(current)
      }
    }
    public static void main(String[] args) {
        int[]arr={1,4,2,9,4,6,5,3};
        int target=4;
        int st=0;
        System.out.println(findIdx(arr,target,st));

    }
}
