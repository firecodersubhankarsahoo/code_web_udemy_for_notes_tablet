import java.util.*;
public class _5_N_queens_count_ways {

    public static int count=0;

    public static void ways(char[][] board,int row){

        if(row==board.length){
            count++;
            return;
        }
        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='q';
                ways(board,row+1);
                board[row][i]='x';

            }
        }
    }
    public static boolean isSafe(char[][] board,int row,int col){
        //vertical up check
        for (int i=row-1;i>=0;i--){
            if(board[i][col]=='q'){
                return false;
            }
        }
        //diagonal left up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='q'){
                return false;
            }
        }
        //diagonal right up
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='q'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=4;
        char[][] chessboard=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j]='x';   // 'x' indicates empty cell
            }
        }
        ways(chessboard,0);
        System.out.println(" Total number of ways to place N queens on the board: " + count);
    }
}
