import java.util.*;
public class stack_using_Arraylist {
    static  class stack{
        static ArrayList<Integer>list=new ArrayList<>();
        //isEmpty
        public static boolean isEmpty(){return list.size()==0;}
        //add element
        public static void push(int ele){
            list.add(ele);
        }
        //remove element from tos and show it
        public static int pop(){
            int tos=list.size()-1;
            int val=list.get(tos);
            list.remove(tos);
            return  val;
        }
        public static int peek(){
            int tos=list.size()-1;
            return list.get(tos);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack st=new stack();
        st.push(26);
        st.push(98);
        st.push(99);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            st.pop();
        }
    }
}
