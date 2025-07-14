import java.util.*;
//print all binary strings of length n such that no two consecutive bits are 1.


public class _13_binary_string_problem {
    public static void printstring(int n,int lastplace, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
    if(lastplace==0){                             // If last place is 0, we can add either 0 or 1
        printstring(n-1,0,str+"0");
        printstring(n-1,1,str+"1");
    }else {
        printstring(n-1,0,str+0);  // If last place is 1, we can only add 0
    }
        // OR  //   OR // OR  // OR  //

//        printstring(n-1,0,str+"0");
//        if(lastplace==0){
//            printstring(n-1,1,str+"1");
//        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=5;
        printstring(n,0,"");

    }
}
