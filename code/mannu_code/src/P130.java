public void solve(char[][] board) {
	int row=board.length;
	if(row==0) return;
	int col=board[0].length;
	//第一行为‘o’的元素
	for(int i=0;i<col;i++){
		if(board[0][i]=='o'){
			dfs(0,i,board);
		}
	}

	//最后一行为‘o’的元素
	for(int i=0;i<col;i++){
		if(board[row-1][i]=='o'){
			dfs(row-1,i,board);
		}
	}

	//第一列为‘o’的元素
	for(int i=0;i<row;i++){
		if(board[i][0]=='o'){
			dfs(i,0,board);
		}
	}

	//最后一列为‘o’的元素
	for(int i=0;i<row;i++){
		if(board[i][col-1]=='o'){
			dfs(i,col-1,board);
		}
	}

	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			if(board[i][j]=='*'){
				board[i][j]='x';
			}

		}
	}
//对没有包围的元素标记
	private void dfs(int i,int j,char[][] board){
		if(i<0||j<0||i>board.length||j>board[0].length){
			return;
		}
		if(board[i][j]=='*'||board[i][j]=='x'){
			return;
		}
		if(board[i][j]=='o'){
			board[i][j]='*';
			dfs(i+1,j,board);
			dfs(i,j+1,board);
			dfs(i-1,j,board);
			dfs(i,j-1,board);
		}

	}

}