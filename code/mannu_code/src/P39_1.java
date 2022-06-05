import java.util.*;

public class P39_1 {
    //analysis:dfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        DFS_CombineSum(candidates,ans,new ArrayList<>(),target,0,0);
        return ans;
    }
    private void DFS_CombineSum(int [] nums,List<List<Integer>> ans,List<Integer> temp,
        int target,int preSum,int start) {
        if (preSum > target) {
            return;
        }
        if (preSum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //
            if (temp.size() == 0 && (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            preSum += nums[i];
            if (preSum <= target) {
                temp.add(nums[i]);
                DFS_CombineSum(nums, ans, temp, target, preSum,i);
                preSum-=temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);//移除刚添加的元素
            } else
                continue;
        }
    }
}
