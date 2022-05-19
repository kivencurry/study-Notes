package DP;
class SolutioncanJump{
	public static void main(String[] args){
		int [] nums={2,0,0};
		new SolutioncanJump().canJump(nums);

	}
	public boolean canJump(int []nums){
		//analysize:if  exist no one node get position 
		int i=0;
		int maxLen=Integer.MIN_VALUE;
		int end=0;
		int n=nums.length;
		//特殊情况[0]
		if(n==1){
			return true;
		}
		while(i<n){
			maxLen=Math.max(maxLen,i+nums[i]);
			if(end==i){
				if(i!=0&&end==maxLen){
					//表示下一跳的区间为长度为0.
					return false;
				}
				if(maxLen>=n){//jump length is longer than n
					return true;

				}
				end=maxLen;//
			}
			i++;

		}
		return maxLen>=n;

	}


}