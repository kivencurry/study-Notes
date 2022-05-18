public class P48
{
	public static void main(String [] args){
		int [][] matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		new P48().rotate(matrix);

	}
	public void rotate(int[][] matrix) {

		int width=matrix.length;//宽，depth
		int length=matrix[0].length;//长度，
		for(int i=0;i<length;i++){
			for(int j=i+1;j<width;j++){
				int temp=matrix[j][i];
				matrix[j][i]=matrix[i][j];
				matrix[i][j]=temp;
			}
		}

		for(int i=0;i<length/2;i++){
			for (int j=0;j<width;j++)
			{
				int temp=matrix[j][i];
				matrix[j][i]=matrix[j][length-1-i];
				matrix[j][length-1-i]=temp;
			}
		
		}
	
        
    }

}