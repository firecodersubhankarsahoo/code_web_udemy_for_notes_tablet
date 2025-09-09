import java.util.*;
public class _7_Duplicate_Parentheses_Code {
    public static boolean isDuplicate(String exp){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);

            if(c==')'){                           //when we encounter a closing bracket we will check for the top of the stack and pop until we get the opening bracket
                int count=0;       //to count the number of elements between the brackets
                while (!st.isEmpty() && st.peek()!='('){            //pop until we get the opening bracket
                    count++;                                      // increment count for each element popped
                    st.pop();                                    //pop the element until we get the opening bracket
                }
                if(count<1){                                   //if count is less than 1 it means there are no elements between the brackets so it is duplicate so return true
                    return true;
                }else {                                     //if count is greater than 1 it means there are elements between the brackets so it is not duplicate .now  pop the opening bracket
                    st.pop();
                }
            }
            else {
                st.push(c);                          //if it is not closing bracket push everything to the stack
            }
        }
        return false;                   //if we reach here it means there are no duplicate brackets so return false

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp1="((a+b))";
        String exp2="(a-b)";
        System.out.println(isDuplicate(exp1));

    }
}
