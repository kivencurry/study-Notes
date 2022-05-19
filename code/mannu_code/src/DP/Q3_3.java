package DP;

public class Q3_3 {
    public static void main(String[] args) {
        int [] nums={3,0,0};
        new Q3_3().canJump(nums);
    }
    public boolean canJump(int[] nums) {
        int step=0,end=nums[0];

        for(int i=0;i<nums.length&&end< nums.length-1;){
            end=nums[i]+i;
            if(nums[i]==0)//更新边界的时候，i==end.  return false
                return false;
            while(i<end){
                if(end>=nums.length-1)
                    return true;
                if(end<nums[i]+i){
                    end=nums[i]+i;
                    step++;
                }
                i++;
            }
        }
        if(end<nums.length-1)
            return false;
        else
            return true;

    }
}
