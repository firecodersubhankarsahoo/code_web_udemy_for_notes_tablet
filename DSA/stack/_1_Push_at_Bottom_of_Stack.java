import java.util.*;

public class _1_Push_at_Bottom_of_Stack {

    public static void pushBottom(Stack<Integer>st,int newitem){
        if (st.isEmpty()) { // base case: if stack is empty, push the new item
            st.push(newitem);
            return;
        }
        int cur=st.pop();
        pushBottom(st,newitem);// recursion call
        st.push(cur);    // push the popped(removed) element back at the time of returning(after base case satisfied) of  recursion
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer>st=new Stack<>();
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);
        st.push(15);
        /*
                      |     |
                      |  15 |  ← TOP
                      |_____|
                      |  14 |
                      |_____|
                      |  13 |
                      |_____|
                      |  12 |
                      |_____|
                      |  11 |
                      |_____|
                      |  10 |  ← BOTTOM
                      |_____|

     */
        int newitem=50;  //item to insert at bottom
        pushBottom(st,newitem);

        /*
                      |     |
                      |  15 |  ← TOP
                      |_____|
                      |  14 |
                      |_____|
                      |  13 |
                      |_____|
                      |  12 |
                      |_____|
                      |  11 |
                      |_____|
                      |  10 |
                      |_____|
                      | 50  |
                      |_____|← BOTTOM

     */
    }



    public static void printStack(Stack<Integer> stack) {  // to print the stack
        Object[] arr = stack.toArray();
        System.out.println("   _____        ← TOP");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println("  |     |");
            System.out.printf("  |  %-2d |\n", arr[i]);
            System.out.println("  |_____|");
        }
        System.out.println("              ← BOTTOM");
    }

}
