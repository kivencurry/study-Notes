package DP;

/**
 * @author cid
 * @create 2022-05-18-10:55
 */
class SolutionUniquePath{
    public static void main(String [] args){
        int [][]matrix={};
        new SolutionUniquePath().UniquePath(matrix);

    }
    public int UniquePath(int [][]matrix){
        int m=matrix.length;//row
        int n=matrix[0].length;//colomnn
        //问题分析：采用动态规划的方法。dp[m-1][n-1]=dp[m-2][n-1]+dp[m-1][n-2]
        //initilize
        int [][]dp=new int [m][n];
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(c==0||r==0){
                    dp[r][c]=1;
                }
                else{
                    dp[r][c]=dp[r-1][c]+dp[r][c-1];
                }
            }
        }
        return dp[m-1][n-1];

    }



}

