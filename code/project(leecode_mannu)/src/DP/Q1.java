package DP;

class SolutionCoinChange{
	public static void main(String [] args){
		int []A={2,5,7};
		int M=27;
		System.out.println(new SolutionCoinChange().coinChange(A, M));

	}
	public int coinChange(int []A,int M){
		//问题分析：采用动态规划的方法。dp[m]=min{dp[m-A[0]]+1,dp[m-A[1]]+1,dp[m-A[A.length-1]]+1};
		int []dp=new int [M+1];
		dp[0]=0;
		for(int i=1;i<=M;i++){
			dp[i]=Integer.MAX_VALUE; 
			int j=0;
			while(j<A.length){
				if(i-A[j]>=0&&dp[i-A[j]]!=Integer.MAX_VALUE){
					dp[i]=Math.min(dp[i-A[j]]+1,dp[i]);
				}
				j++;
			}

		}
		if(dp[M]==Integer.MAX_VALUE){
			return -1;
		}
		
		return dp[M];
		
	}
}