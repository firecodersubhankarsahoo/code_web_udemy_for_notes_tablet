/*
import java.util.*;
public class _9_print_x_to_the_pow_n {
    public static int pow(int x,int n){
        if(n==0){
            return 1;
        }
//        int currpow=pow(x,n-1);
//        int ans=x*currpow;
//        return ans;

             //or
        return x*(pow(x,n-1));
    }
    public static void main(String[] args) {
        int x=10;
        int n=5;
        System.out.println(pow(x,n));
    }
}
*/


//   OPTIMISED solution on  O(log n) Time complexity

public class _9_print_x_to_the_pow_n {
    public static int pow(int x,int n){
        if(n==0){                                // base case
            return 1;
        }
        int halfpowerSQ=pow(x,n/2)*pow(x,n/2);  // calculate x^(n/2) and square it
        // if n is even, we just return halfpowerSQ
        // if n is odd, we multiply x once more to get x^n
        if(n%2!=0){
            halfpowerSQ= x*halfpowerSQ;
        }
        return halfpowerSQ;  // return the result
    }
    public static void main(String[] args) {
        int x=2;
        int n=5;
        System.out.println(pow(x,n));
    }
}





