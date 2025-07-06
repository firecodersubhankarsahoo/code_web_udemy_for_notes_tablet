import java.util.*;

/*
  Tiling Problem:--
Given a "2 x n" board and tiles of size "2 x 1", count the number
of ways to tile the given board using the 2 x 1 tiles.
(A tile can either be placed horizontally or vertically.)

*/


public class _10_tiling_problem {
    public static int tiling(int n){
        if(n==0 ||n==1){ // base case
            return 1;
        }
        //for vertical choice
        int vertical=tiling(n-1);   // place a tile vertically, reducing the board size by 1
        //for horizontal choice
        int horizontal=tiling(n-2);  // place two tiles horizontally, reducing the board size by 2
        int total_no_of_ways=vertical+horizontal; // total ways = ways to place vertically + ways to place horizontally
        return total_no_of_ways;
    }
    public static void main(String[] args) {
        int n=7;
        System.out.println(tiling(n));

    }
}
