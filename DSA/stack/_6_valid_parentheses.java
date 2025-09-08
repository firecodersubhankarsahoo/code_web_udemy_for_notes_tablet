import java.util.*;

public class _6_valid_parentheses {

    public static boolean isValid(String str){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='('||c=='{'||c=='['){   //if opening bracket then push it to the stack
                st.push(c);
            }else{
                if(st.isEmpty()){         //if closing bracket and stack is empty then return false as there is no matching opening bracket
                    return false;
                }

                if((st.peek()=='('&& c==')')
                        || (st.peek()=='{' && c=='}' )
                        || (st.peek()=='[' && c==']')){  //if closing bracket matches with the top opening bracket then pop the top element
                    st.pop();
                }else {
                    return false; //if closing bracket does not match with the top opening bracket then return false
                }
            }
        }
        if(st.isEmpty()){ //if stack is empty as all opening brackets are matched with closing brackets then return true
            return true;
        }else {
            return false;        //if stack is not empty as there are some opening brackets which are not matched with closing brackets then return false
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String parenthesis = "{[()]()}";
        boolean result=isValid(parenthesis);
        if (result){
            System.out.println("valid parenthesis");
        }else {
            System.out.println("invalid parenthesis");
        }


    }
}
