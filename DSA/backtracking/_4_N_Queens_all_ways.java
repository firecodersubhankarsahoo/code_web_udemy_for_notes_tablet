import java.util.*;
// N-Queens problem is a classic backtracking problem where we need to place N queens on an N x N chessboard such that no two queens threaten each other.

public class _4_N_Queens_all_ways {
    public static void Nqueens(char[][] board,int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int i=0;i<board.length;i++){  // iterate through each column in the current row
            if(isSafe(board,row,i)) {    // check if placing a queen at (row, i) is safe

                board[row][i] = 'q';              // place queen at (row, i)

                Nqueens(board, row + 1);  // recursively call for the next row

                board[row][i] = 'x';         // backtrack by removing the queen from (row, i) as we need to explore other possibilities
            }
        }
    }
    public static boolean isSafe(char[][]board,int row,int col){
        //check vertical up
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='q'){
                return false;
            }
        }
        //check diagonal left up
        for (int i=row-1,j=col-1 ; i>=0&&j>=0 ; i--,j--){
            if(board[i][j]=='q'){
                return false;
            }
        }
        //check diagonal right up
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if( j < board[0].length && board[i][j] == 'q') {
                return false;
            }
        }

        return true;   // if queen can be placed at (row, col) without being attacked by any other queen return true

    }



    public static void printBoard(char[][] board){
        System.out.println("______chessboard______");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=4;
        char[][] chessboard =new char[n][n];

        //initialization by making all the place as empty at first
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                chessboard[i][j]='x';   // 'x' indicates empty cell
            }
        }
        Nqueens(chessboard,0);


    }
}
