import java.util.*;

public class _3_find_permutations {

    public static void findPermutation(String str,String ans){
        //base case
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);                                         //current character
            String newstr=str.substring(0,i)+str.substring(i+1,str.length());  //removing the current character
            findPermutation(newstr,ans+curr);    //
        }


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String str="abc";
            findPermutation(str,"");

    }
}
