import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class  P47
{/*
问题分析：深度优先搜索，含有重复元素。每一个数组都可以作为开始。
用一个map记住当前元素的index，直接跳过该值，
*/
	public static void main(String[] args)
	{
		int []nums ={3,3,0,3};
		new P47().permuteUnique(nums);
	}
	public List<List<Integer>> permuteUnique(int[] nums) {
		if(nums.length==0){
			return null;
		}
		List<List<Integer>> ans=new ArrayList<>();
		Arrays.sort(nums);
		getPermuteUnique(nums,ans,new ArrayList<>(),new Stack<>());
		return ans;
	}
	private void getPermuteUnique(int []nums,List<List<Integer>> ans,List<Integer> temp,Stack<Integer> index){
		if(temp.size()==nums.length){//达到最大深度
			ans.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(index.contains(i)) continue;//已经添加过该元素
			if(i>0&&nums[i]==nums[i-1]&&!index.contains(i-1)){//重复的元素，只添加
				continue;
			}
			temp.add(nums[i]);
			index.push(i);
			getPermuteUnique(nums,ans,temp,index);
			temp.remove(temp.size()-1);
			index.pop();

		}
	}
}
