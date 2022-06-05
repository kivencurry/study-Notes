public class P41 {
    public int firstMissingPositive(int[] nums) {
        //analysise:change the position
        int n=nums.length;
        for(int i=0;i<n;){
            if(nums[i]<=0||nums[i]>n||nums[i]==i+1){
                i++;
                continue;
            }
            //nums[i]!=i+1
            else {
                int temp=nums[nums[i]-1];
                int temp1=nums[i];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;
                if(temp1==temp){
                    i++;
                }
            }
        }
        int i=0;
        while(i<n&&nums[i]==i+1){
            i++;
        }
        return i+1;
    }
}
