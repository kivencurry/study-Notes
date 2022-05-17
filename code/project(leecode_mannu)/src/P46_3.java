import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
//排队问题，BC不能挨着，DE不能挨着
class P46_3
{
	public static void main(String []args){
		String [] nums={"A","B","C"};
		new P46_3().permute(nums);
	
	}

	public List<List<String>> permute(String [] nums) {
		if(nums.length==0){
			return null;
		}
		List<List<String>> ans=new ArrayList<>();
		callBack(ans,new ArrayList<>(),nums);
		return ans;
	}
	private void callBack(List<List<String>> ans,List<String> temp,String [] nums){
		if(temp.size()==nums.length){
//			int lenOfBC=temp.indexOf(nums[1])-temp.indexOf(nums[2]);
//			int lenOfDE=temp.indexOf(nums[3])-temp.indexOf(nums[4]);
//
//			if(Math.abs(lenOfBC)!=1&&Math.abs(lenOfDE)!=1){
//
//			}
			ans.add(new ArrayList(temp));
		return;
		}
		for(int i=0;i<nums.length;i++){

			if(temp.contains(nums[i])){
			continue;}

			//如果前面是B后面就不应该是C.反过来也是
			if(!temp.isEmpty()&&temp.get(temp.size()-1).equals("B")){
				if(nums[i].equals("C")){
					continue;
				}
			}
			temp.add(nums[i]);
			callBack(ans,temp,nums);
			temp.remove(temp.size()-1);
		}

	
	}
	
}