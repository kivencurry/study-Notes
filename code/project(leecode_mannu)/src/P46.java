import java.util.*; 

class P46
{
	public static void main(String []args){
		int [] nums={1,2,3};
		new P46().permute(nums);

	
	}

	public List<List<Integer>> permute(int[] nums) {
		if(nums.length==0){
			return null;
		}
		List<List<Integer>> ans=new ArrayList<>();
		callBack(ans,new ArrayList<>(),nums);
		return ans;
	}
	private void callBack(List<List<Integer>> ans,List<Integer> temp,int [] nums){
		if(temp.size()==nums.length){
		ans.add(new ArrayList(temp));
		return;
		}
		for(int i=0;i<nums.length;i++){
			if(temp.contains(nums[i])){
			continue;}
			temp.add(nums[i]);
			callBack(ans,temp,nums);
			temp.remove(temp.size()-1);
		}

	}
	
}