import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P40_test {
    public static void main(String[] args) {
        //[2,7,6,3,5,1]
        //9
        //[2,5,2,1,2]
        //5
        //[1,2,2,2,5]
        int nums[] = {2,5,2,1,2};
        int target = 5;
        System.out.println(new P40_test().combinationSum2(nums, target));
    }
    //analysis:dfs
     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        DFS_CombineSum(candidates,ans,new ArrayList<>(),0);
        return ans;
    }
    private void DFS_CombineSum(int [] nums,List<List<Integer>> ans,List<Integer> temp, int start) {
        if (start== nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            //
//            if (temp.size()==0 && ( i>0&&nums[i] == nums[i - 1])) {
//                continue;
//            }
            temp.add(nums[i]);
            DFS_CombineSum(nums, ans, temp, i+1);
            temp.remove(temp.size() - 1);//移除刚添加的元素

        }
    }
}
