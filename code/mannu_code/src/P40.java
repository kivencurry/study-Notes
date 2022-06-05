import java.util.*;

public class P40 {
    public static void main(String[] args) {
        //[2,7,6,3,5,1]
        //9
        //[2,5,2,1,2]
        //5
        //[1,2,2,2,5]
        int nums[] = {2,5,2,1,2};
        int target = 5;
        System.out.println(new P40().combinationSum2(nums, target));
    }
    //analysis:dfs
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i>start && ( nums[i] == nums[i - 1])) {
                continue;
            }
            preSum += nums[i];
            if (preSum <= target) {
                temp.add(nums[i]);
                DFS_CombineSum(nums, ans, temp, target, preSum,i+1);
                preSum-=temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);//移除刚添加的元素
            } else
                continue;
        }
    }
}
