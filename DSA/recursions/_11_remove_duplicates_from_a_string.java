import java.util.*;
public class _11_remove_duplicates_from_a_string {
    static boolean[]arr = new boolean[26];           // Array to keep track of characters seen
    static  StringBuilder ans=new StringBuilder();
    //stringbuilder is used instead of string to avoid immutability issues and for better performance
    public static void removeDuplicate(String str,int idx){
        if(idx==str.length()){                    // Base case: if we have reached the end of the string
            System.out.println(ans);
            return;
        }
        char currentChar=str.charAt(idx);
        if(arr[currentChar-'a']==false){         // Check if the character has not been seen before
            ans.append(currentChar);
            arr[currentChar-'a']=true;
            removeDuplicate(str,idx+1);
        }else {
            removeDuplicate(str,idx+1);     //duplicate character found, skip it
        }
    }
    public static void main(String[] args) {
        String str="abacadaeaf";
        int idx=0; // Starting index
        removeDuplicate(str, idx); // Call the recursive function
    }
}
