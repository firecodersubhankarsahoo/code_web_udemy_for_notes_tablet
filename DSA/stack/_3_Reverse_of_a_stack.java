/*

import java.util.*;
// Ans 1:--->>  //not efficient

public class _3_Reverse_of_a_stack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer>st=new Stack<>();
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);
        st.push(15);
        Stack<Integer>newStack=new Stack<>();
        while (!st.isEmpty()){
            newStack.push(st.pop());
        }

        //print  newstack which is the reverse of the given stack
    }
}
*/

/// ///////////////////////////////////////Efficient Approach//////////////////////////////////////////////////////



import java.util.*;
// Ans 2:--->>  // efficient approach using recursion

public class _3_Reverse_of_a_stack {

    public static void pushBottom(Stack<Integer>st,int newitem){
        if (st.isEmpty()) { // base case: if stack is empty, push the new item
            st.push(newitem);
            return;
        }
        int tos=st.pop();
        pushBottom(st,newitem);// recursion call
        st.push(tos);    // push the popped(removed) element back at the time of returning(after base case satisfied) of  recursion
    }

    public static void ReverseStack(Stack<Integer>st){
        if(st.isEmpty()){
            return;
        }
        int tos=st.pop();
        ReverseStack(st);    // reverse the remaining stack
        pushBottom(st,tos);   // insert popped element at bottom
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer>st=new Stack<>();
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        printStack(st);
        ReverseStack(st);
        System.out.println("after reverse of the stack the stack is ");
        printStack(st);
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