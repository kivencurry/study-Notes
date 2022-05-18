/*
问题分析：
P50
采用递归的方法，
将2的2N次方，化为2的N次方想乘
*/


import java.util.HashMap;

class Solution {
	public static void main(String[] args) {
		double x=2;
		int n=6;
		System.out.println(new Solution().myPow(x, n));
	}
    public double myPow(double x, int n) {
		HashMap<Integer,Double> map=new HashMap<>();
		if(n>0)
			return getMyPow(x,n,map);
		else
			return 1/getMyPow(x,-n,map);
        
    }
	private double getMyPow(double x,int n,HashMap<Integer,Double> map){
	if(n==0)
		return 1;
	if(n==1)
		return x;
	if(map.containsKey(n))
		return map.get(n);
		double n1=getMyPow(x,n/2,map);
		map.put(n/2,n1);
		double n2=getMyPow(x,n/2,map);
		double n3=getMyPow(x,n%2,map);
		double res=n1*n2*n3;
	return res;

	}
}