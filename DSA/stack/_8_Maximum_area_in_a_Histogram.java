import java.util.*;
// best optimised solution in O(n)

public class _8_Maximum_area_in_a_Histogram {


    public static int[] nextSmallerRight(int[]arr){
        Stack<Integer>st=new Stack<>();               //will store the index of elements
        int [] nextSR=new int[arr.length];           //store the index of next smaller at right
        for(int i=arr.length-1;i>=0;i--){
            while (!st.isEmpty()&&arr[st.peek()]>=arr[i]){              //pop until we find the smaller element(means pop if the higher or same value comes) or stack becomes empty
                st.pop();
            }
            if(st.isEmpty()){
                nextSR[i]=arr.length;         // if stack becomes empty then  there is no smaller item  on the right side so we will take the index as length of the array as the width will be calculated as nsr-nsl-1
            }else {
                nextSR[i]=st.peek();         //if stack is not empty then the top element is the next smaller element
            }
            st.push(i);                     //push the index of current element to the stack
        }
        return nextSR;                     //return the array containing the index of next smaller element on the right side for each element
    }


    public static int[] nextSmallerLeft(int[]arr ){
        Stack<Integer>st=new Stack<>();               //will store the index of elements
        int [] nextSL=new int[arr.length];           //store the index of next smaller at left
        for(int i=0;i<arr.length;i++){
            while (!st.isEmpty()&& arr[st.peek()]>=arr[i]){             //pop until we find the smaller element(means pop if the higher or same value comes) or stack becomes empty
                st.pop();
            }
            if(st.isEmpty()){                               //if stack becomes empty then there is no smaller item on the left side so we will take the index as -1
                nextSL[i]=-1;
            }else {
                nextSL[i]=st.peek();                      //if stack is not empty then the top element is the next smaller element
            }
            st.push(i);                                   //push the index of current element to the stack
        }
        return nextSL;                                  //return the array containing the index of next smaller element on the left side for each element
    }

    public static int maxArea(int[]bars){
        int[]nsr=nextSmallerRight(bars);            //store the index of next smaller element on the right side for each element
        int[]nsl=nextSmallerLeft(bars);            //store the index of next smaller element on the left side for each element
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<bars.length;i++){
            int hight=bars[i];
            int width=nsr[i]-nsl[i]-1;                //width = index of next smaller at right - index of next smaller at left -1
            int area=hight*width;                    //area of rectengle for current bar
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] bars={2,1,5,6,2,3};               //hight if the bars are stored in this array  and the width of each bar is 1(by default)
        System.out.println( "area of the largest rectangle is= "+maxArea(bars));
    }
}



/*

--------------------------------------------Problem Statement--------------------------------------------------------------------

        Given an array where each element represents the height of a bar in a histogram, find the area of the largest rectangle that can be formed inside the histogram.

        For example:

        bars = [2, 1, 5, 6, 2, 3]


        Visual Histogram:

                |
                |        |
                |    |   |
                |    |   |   |
        |       |    |   |   |
        |   |   |    |   |   |
        -------------------------
          2   1   5   6   2   3


        The largest rectangle here has area 10 (using bars 5 and 6).

--------------------------------------------🔑 Approach (Intuition)-----------------------------------------------------------

                For each bar, we want to know:

                    1. How far can it extend to the left (until a smaller bar appears).

                    2. How far can it extend to the right (until a smaller bar appears).

                   So, the rectangle with height bars[i] will have width:
                                width = nextSmallerRight[i] - nextSmallerLeft[i] - 1


                        Then the area for bar i is:

                        area = bars[i] * width

                        We compute this for all bars and take the maximum.





    ------------------------------------ ⚙️ Code Walkthrough-------------------------------------

-->>1. Next Smaller to the Right (NSR)

            public static int[] nextSmallerRight(int[] arr) {
                Stack<Integer> st = new Stack<>();
                int[] nextSR = new int[arr.length];

                for (int i = arr.length - 1; i >= 0; i--) {
                    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        nextSR[i] = arr.length;   // No smaller element on right
                    } else {
                        nextSR[i] = st.peek();    // Index of next smaller on right
                    }
                    st.push(i);
                }
                return nextSR;
            }

                       > Traverse from right to left.

                        >Use a stack to store indices of bars.

                        >If stack is empty → no smaller element on right → take arr.length.

                        >Otherwise, the top of stack = next smaller index.

            👉 Example for [2,1,5,6,2,3] → NSR = [1, 6, 4, 4, 6, 6]




-->>2. Next Smaller to the Left (NSL)

            public static int[] nextSmallerLeft(int[] arr) {
                Stack<Integer> st = new Stack<>();
                int[] nextSL = new int[arr.length];

                for (int i = 0; i < arr.length; i++) {
                    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                        st.pop();
                    }
                    if (st.isEmpty()) {
                        nextSL[i] = -1;          // No smaller element on left
                    } else {
                        nextSL[i] = st.peek();   // Index of next smaller on left
                    }
                    st.push(i);
                }
                return nextSL;
            }


                           > Traverse from left to right.

                           > If stack is empty → no smaller element on left → -1.

                           > Otherwise, top of stack = next smaller index.

            👉 Example for [2,1,5,6,2,3] → NSL = [-1, -1, 1, 2, 1, 4]


--->>>3. Compute Max Area

    public static int maxArea(int[] bars) {
        int[] nsr = nextSmallerRight(bars);
        int[] nsl = nextSmallerLeft(bars);
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < bars.length; i++) {
            int height = bars[i];
            int width = nsr[i] - nsl[i] - 1;   // formula
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
                    --For each bar:

                    > Height = bars[i]

                    > Width = (next smaller right index – next smaller left index – 1)

                    > Calculate area and update max.

                    👉 For [2,1,5,6,2,3], max area = 10



----------------------------------------📊 Dry Run (Step by Step)----------------------------------------------------------------

        For bars = [2,1,5,6,2,3]

        NSR = [1, 6, 4, 4, 6, 6]

        NSL = [-1, -1, 1, 2, 1, 4]

Now calculate areas:

                        i	bar[i]  	NSL  	 NSR    	width = NSR-NSL-1   	area = h*width

                        0	  2	       -1         1	              1	                     2

                        1	  1	       -1	      6	              6	                     6

                        2	  5	        1	      4	              2	                     10

                        3	  6	        2	      4	              1	                     6

                        4	  2     	1	      6	              4	                     8

                        5	  3	        4	      6	              1	                     3


            👉 Maximum area = 10



--------------------------------🎯 Why Stack is Needed?---------------------------------------------------

            A naive approach checks left & right for every bar → O(n²) time.

            Stack helps track nearest smaller efficiently → O(n) time.









*/