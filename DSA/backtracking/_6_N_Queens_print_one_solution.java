import java.util.*;
public class _6_N_Queens_print_one_solution {

    public static boolean Nqueen(char[][]board,int row){
        if(row==board.length){
            printchess(board);
            return true;
        }

        for(int i=0;i<board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]='q';
                if(Nqueen(board,row+1)){  // if we find a solution, we return true
                    return true;
                }
                board[row][i]='x';
            }
        }
        return false;
    }

    public static boolean isSafe(char[][]board,int row,int col){

        //vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='q'){
                return false;
            }
        }
        //left diagonal up
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='q'){
                return false;
            }
        }
        //right diagonal up
        for(int i=row-1,j=col+1;i>=0&&j<board.length;i--,j++){
            if(board[i][j]=='q'){
                return false;
            }
        }
    return true;
    }

    public static void printchess(char[][] board){
        int n=board.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=4;
        char[][]chess=new  char[n][n];
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                chess[i][j]='x';
            }
        }
        Nqueen(chess,0);


    }
}
