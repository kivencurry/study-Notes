class P34{
	public static void main(String[] args) {
		int []nums={1};
		int target=1;

		new P34().searchRange(nums,target);
	}
	public int[] searchRange(int[] nums, int target) {
		int [] res={-1,-1};
		int start=0;
		int end=nums.length-1;
		int mid=0;
		while(start<=end){
			mid=(end+start)>>>1;
			if(nums[mid]==target){
				int targetStart=mid;
				int targetEnd=mid;
				while(targetStart>=0&&nums[targetStart]==target){
                    targetStart--;
                }
				while (targetEnd<nums.length&&nums[targetEnd]==target){
                    targetEnd++;
                }
				res[0]=targetStart+1;
				res[1]=targetEnd-1;
				return res;
			}
			else if(target<nums[mid]){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		return res;
        
    }
	
}
