import java.util.*;
public class stack_using_Linkedlist {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.next=null;
            this.data=data;
        }
    }
static  class Stack{
        static Node head=null;
        // isEmpty
        public static boolean isEmpty(){
            return head==null;
        }
        //push
        public static void push(int data){
            Node newnode=new Node(data);
            if (isEmpty()){
                head=newnode;
                return;
            }
            newnode.next=head;
            head=newnode;
        }
        //pop
    public static int pop(){
            if (isEmpty()){
                return -1;
            }
            Node top=head;
            head=head.next;
            return top.data;
    }
    //peek
    public static int peek(){
            if (isEmpty()){
                return -1;
            }
            return head.data;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack st=new Stack();
        st.push(26);
        st.push(98);
        st.push(99);
        while (!st.isEmpty()) {
            System.out.println(st.peek());
            st.pop();
        }
    }
}
