/*
问题分析：
P50
采用递归的方法，
将2的2N次方，化为2的N次方想乘
*/



class Solution {
    public double myPow(double x, int n) {
		return getMyPow(x,n);
        
    }
	private double getMyPow(double x,int n){
	if(n==0)
		return 1;
	if(n==1)
		return x;
	return getMyPow(x,n/2)*getMyPow(x,n/2)*get(x,n%2);
	}
}