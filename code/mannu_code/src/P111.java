//bfs when the node has no left and right children.
//class  P111 {	public int minDepth(TreeNode root) {
//	//BFS
//	int depth=0;
//	if(root==null){
//		return depth;
//	}
//	Queue<TreeNode> que=new LinkedList<>();
//	que.offer(root);
//	while(!que.isEmpty()){
//		int levelNum=que.size();
//		depth++;
//		for(int i=0;i<levelNum;i++){
//			TreeNode curr=que.poll();
//			if(curr.left==null&&curr.right==null){
//				return depth;
//			}
//			else{
//				if(curr.left!=null){
//					que.offer(curr.left);
//				}
//				if(curr.right!=null){
//					que.offer(curr.right);
//				}
//			}
//		}
//	}
//	return depth;
//	}
	
//}
