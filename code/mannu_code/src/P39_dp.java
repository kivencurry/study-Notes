import java.util.*;

public class P39_dp {
    //analysis:dp
    //对于等于5的可能的集合的计算是nums[i]+{ans_sub(target-nums[i])}
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);//sort
        if(target<nums[0]){
            return new ArrayList<>();
        }
        List<List<List<Integer>>> ans=new ArrayList<>();
        for(int i=0;i<=target;i++){
            //List<List<Integer>> temp1=new ArrayList<>();
            ans.add(i,new ArrayList<>());
        }
        for(int i=0;i<nums.length;i++){
            for(int sum=nums[i];sum<=target;sum++){
                List<List<Integer>> ans_sum=ans.get(sum);
                List<List<Integer>> ans_sub=ans.get(sum-nums[i]);
                if(sum==nums[i]){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    ans_sum.add(temp);
                }
                //如果ans_sub不为0的话
                for(int j=0;j<ans_sub.size();j++){
                    List<Integer> list2=new ArrayList<>(ans_sub.get(j));
                    list2.add(nums[i]);
                    ans_sum.add(list2);
                }
            }
        }
        return ans.get(target);
    }
}
