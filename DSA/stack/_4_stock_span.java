import java.util.*;
/* stock span problem
 The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days.
 The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Naive Approach:--->> O(n^2)
 for each element we will check how many previous elements are smaller than or equal to it

Efficient Approach:--->> O(n)
 We can use a stack to keep track of the indices of the days. We will iterate through the array and for each element we will pop elements from the stack until we find an element which is greater than the current element. The span will be the difference between the current index and the index of the element at the top of the stack. If the stack is empty then the span will be the current index + 1. Finally we will push the current index onto the stack.
*/




public class _4_stock_span {
    public static void calculateSpan(int[]stockPrice,int[]span){
        Stack<Integer>st=new Stack<>();
        st.push(0);               // push the index of the first element
        span[0]=1;                     // span of the first element is always 1

        for (int i = 1; i < stockPrice.length; i++) {
            int currPrice=stockPrice[i];
            while (!st.isEmpty() && (currPrice>stockPrice[st.peek()]) ){  // pop elements from the stack until we find an element which is greater than the current element
                st.pop();
            }

            if (st.isEmpty()){                          // if stack is empty then the span will be the current index + 1
                span[i]=i+1;
            }else {
                span[i]=i-st.peek();                  // else the span will be the difference between the current index and the index of the element at the top of the stack
            }
            st.push(i);                        // push the current index onto the stack
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[]stockPrice={100,80,60,70,60,85,100};
        int[]span=new int[stockPrice.length];               // span array to store the span values
        calculateSpan(stockPrice,span);
        System.out.println(Arrays.toString(span));         // print the span array

    }
}




/*
              Price (↑)
100 |  █ |   |   |   |   |   |   | █ |
 95 |  █ |   |   |   |   |   |   | █ |
 90 |  █ |   |   |   |   |   |   | █ |
 85 |  █ |   |   |   |   |   | █ | █ |
 80 |  █ | █ |   |   |   |   | █ | █ |
 75 |  █ | █ |   |   |   | █ | █ | █ |
 70 |  █ | █ |   | █ |   | █ | █ | █ |
 65 |  █ | █ |   | █ |   | █ | █ | █ |
 60 |  █ | █ | █ | █ | █ | █ | █ | █ |
     +---+---+---+---+---+---+---+---+
day->  D1  D2  D3  D4  D5  D6  D7  D8
      100  80  60  70  60  75  85 100   <<--stock price




 */