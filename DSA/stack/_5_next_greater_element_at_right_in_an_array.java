import java.util.*;

public class _5_next_greater_element_at_right_in_an_array {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]arr={6,8,0,1,3};
        Stack<Integer>st=new Stack<>();  //store the index of elements to find the next greater element
        int [] nextG=new int[arr.length];
        for (int i=arr.length-1;i>=0;i--){
            //step 1: keep popping the elements from the stack until find the greater element or stack becomes empty
            while (!st.isEmpty()&& st.peek()<arr[i]){
                st.pop();
            }
            if (st.isEmpty()){    //if stack is empty then there is no greater element on the right side
                nextG[i]=-1;
            }else {
                nextG[i]=st.peek();       //if stack is not empty then the top element is the next greater element
            }
            st.push(arr[i]);         //push the current element to the stack
        }
        for(int x:nextG){
            System.out.print(x+" ");
        }
    }
}
