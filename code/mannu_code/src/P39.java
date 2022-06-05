import java.util.*;

public class P39 {
    public static void main(String[] args) {
        //[2,7,6,3,5,1]
        //9
        int nums[]={2,7,6,3,5,1};
        int target=9;
        System.out.println(new P39().combinationSum(nums, target));
    }
    //analysis:dfs
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        DFS_CombineSum(candidates,ans,new ArrayList<>(),target,0);
        //去重复元素
        ans=DeleteDuplicate(ans);
        return ans;
    }
    private void DFS_CombineSum(int [] nums,List<List<Integer>> ans,List<Integer> temp,int target,int preSum) {
        if (preSum > target) {
            return;
        }
        if (preSum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //
            if (temp.size() == 0 && (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            preSum += nums[i];
            if (preSum <= target) {
                temp.add(nums[i]);
                DFS_CombineSum(nums, ans, temp, target, preSum);
                preSum-=temp.get(temp.size() - 1);
                temp.remove(temp.size() - 1);//移除刚添加的元素


            } else
                continue;
        }

    }
    private List<List<Integer>> DeleteDuplicate(List<List<Integer>> ans){
        List<String> key=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();

        for(List<Integer> list:ans){
            List<Integer> temp=new ArrayList<>(list);
            Collections.sort(temp);
            String str="";
            for(int e:temp){
                str=str+e+"@";
            }
            if(key.contains(str)){

                continue;
            }
            else{
                key.add(str);
                res.add(list);
            }
        }
        return res;

    }
}
