import java.util.*;

public class P37 {
    public static void main(String[] args) {
       char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
       new P37().solveSudoku(board);
    }
    public void solveSudoku(char[][] board) {
        find_Solution(board);  
    }
    private boolean find_Solution(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    char temp='1';
                    while(temp<='9'){
                        if(isValid(i,j,board,temp)){
                            board[i][j]=temp;   
                            if(find_Solution(board)==true){
                                return true;
                            }
                            else{
                                //has no number to filling
                                board[i][j]='.';   
                            }  
                        }
                        temp++;   
                    }
                    return false;     
                } 
            }
        }
        return true;
    }
    private boolean isValid(int row,int col,char[][]board,char temp){
        //row
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==temp){
                return false;
            }

        }
        //col
        for(int i=0;i<board.length;i++){
            if(board[i][col]==temp){
                return false;
            }

        }
        //box
        int row_i=row/3*3;
        int col_j=col/3*3;
        for(int i=0;i<3;i++ ){
            for(int j=0;j<3;j++){
                if(board[i+row_i][j+col_j]==temp){
                    return false;
                }
            }
        }
        return true;

    }   
}

