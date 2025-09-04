import java.util.*;

public class _2_Reverse_of_a_string_using_Stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character>st=new Stack<>();
        int idx=0;
        String str="abcdef";
        for (int i = 0; i < str.length(); i++) {   // Push each character of the string into the stack
            st.push(str.charAt(i));
        }

        StringBuilder stri=new StringBuilder();

        while (!st.isEmpty()){    // Push each character of the string into the stack
            stri.append(st.pop());
        }
        System.out.println(stri);

    }
}
