import java.util.HashMap;
public class preSum {
	public static void main(String[] args){
		int [] nums={1,1};
		int k=2;
		System.out.println(new preSum().getNum(nums, k));
	}
	private int getNum(int []nums,int k){
		int n=0;//记录个数
		int sum=0;//前缀和
		HashMap<Integer,Integer> map=new HashMap<>();
		//key 为presum的和，value为presum的个数
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
			int temp=sum-k;
			n+=map.getOrDefault(temp,0);
			map.put(sum,map.getOrDefault(map.get(sum),0)+1);
		}
		return n;
	}
}
