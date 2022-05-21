import java.util.*;
/*
DP   get the maxmimum left and right height
*/
class P42 {
	 public int trap(int[] height) {
	 	int sum=0;//the initil trapping water
	 	int n=height.length;
	 	int leftmax[]=new int [n];
	 	int rightmax[]=new int [n];
	 	//get max left height
	 	for(int i=1;i<n;i++){
	 		//the left max can be the leftself and the leftmax of left.
	 		leftmax[i]=Math.max(height[i-1],leftmax[i-1]);
	 	}
	 	for(int i=n-2;i>=0;i--){
	 		rightmax[i]=Math.max(height[i+1],rightmax[i+1]);

	 	}
	 	for(int i=1;i<n;i++){
	 		int min=Math.min(leftmax[i],rightmax[i]);
	 		if(min>height[i]){
	 			sum+=min-height[i];
	 		}
	 	}
	 	return sum;    
    }
/*
double pointer
问题分析：对于leftmax只用了一次，可以不用数组。对于rightmax因为是从右向左更新的，因此需要用到数组。可以通过判定
i的微分（走势），来确定.if（height[left-1]<height[right+1]）则i两侧的最小值肯定是从左边更新。同理，则是右边更新
*/
    public int trap_1(int[] height) {
    	int sum=0;
    	int n=height.length;
    	int leftmax=0;
    	int rightmax=0;
    	int left=1;
    	int right=n-2;
    	for(int i=1;i<n;i++){
    		if(height[left-1]<height[right+1]){
    			leftmax=Math.max(leftmax,height[left-1]);
    			int min=leftmax;
    			if(min>height[left]){
    				sum+=min-height[left];
    			}
    			left++;
    		}
    		else{
    			rightmax=Math.max(rightmax,height[right+1]);
    			int min=rightmax;
    			if(min>height[right]){
    				sum+=min-height[right];
    			}
    			right--;
    		}
    	}
    	return sum;
    }
    /*
stack 
采用栈操作的方法。
    */
    public int trap_2(int[] height) {
    	int n=height.length;
    	int sum=0;
    	int curr=0;
    	Stack<Integer> stack=new Stack<>();
    	while(curr<n){
    		while(!stack.isEmpty()&&height[curr]>=stack.peek()){
    			int h=height[stack.peek()];
    			stack.pop();
    			if(stack.isEmpty()){
    				break;
    			}
    			int distance=curr-stack.peek()-1;
    			int min=Math.min(height[curr],height[stack.peek()]);
    			sum+=distance*(min-h);
    		}
    		stack.push(curr);
    		curr++;
    	}
    	return sum;

    }
	public int trap6(int[] height) {
		int sum = 0;
		Stack<Integer> stack = new Stack<>();
		int current = 0;
		while (current < height.length) {
			//如果栈不空并且当前指向的高度大于栈顶高度就一直循环
			while (!stack.empty() && height[current] > height[stack.peek()]) {
				int h = height[stack.peek()]; //取出要出栈的元素
				stack.pop(); //出栈
				if (stack.empty()) { // 栈空就出去
					break;
				}
				int distance = current - stack.peek() - 1; //两堵墙之前的距离。
				int min = Math.min(height[stack.peek()], height[current]);
				sum = sum + distance * (min - h);
			}
			stack.push(current); //当前指向的墙入栈
			current++; //指针后移
		}
		return sum;
	}


}


