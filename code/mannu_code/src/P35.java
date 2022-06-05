import java.util.*;
/*
analysis:
二分法插值
*/
public class P35 {
	public int searchInsert(int[] nums, int target) {
    int start = 0;
    int end = nums.length - 1;
    if (nums.length == 0) {
        return 0;
    }
    int mid=0;
    while (start < end) {
         mid = (start + end) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            end = mid-1;
        } else {
            start = mid + 1;
        }
    }
       System.out.println(mid);
       System.out.print(start);
	   System.out.print(end);
       if(target>nums[start]){
        return start + 1;
    }
    else{
        return start;
    }
    
}
 
}

