package DP;

/**
 * @author cid
 * @create 2022-05-18-10:57
 */
class Solution{
    public static void main(String []args){
        int [] A={2,3,1,1,4};
        System.out.println(new Solution().canJump(A));

    }
    public boolean canJump(int []A){
		/*
		能否跳到第j个点，当j+A[j]>A.length时，表示可以跳到
		*/
        int n=A.length;
        int i=0;
        boolean []dp=new boolean[n];
        dp[0]=true;
        while(i<n){
            int j=0;
            dp[i]=false;
            while(j<i){//can jump i
                if(j+A[j]>=i){
                    dp[i]=true;
                    break;
                }
                j++;
            }
            if(dp[i]&&i+A[i]>=n){
                return true;
            }
            i++;
        }
        return false;
    }
}
