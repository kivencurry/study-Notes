import java.util.*;
/*
analysis:
tag every number if it has occur twice in the same row or column,or in the grid. return false
*/
public class P36 {
   public boolean isValidSudoku(char[][] board) {
	   HashSet set=new HashSet<String>();
	   for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]!='.'){
					char c=board[i][j];
					if(!(set.add(c+"in the row"+i)&&set.add(c+"in the col"+j)&&set.add(c+"in the table"+i/3+j/3))){
						return false;
					}
				}
				
			}
		}
		return true;
   }
}

