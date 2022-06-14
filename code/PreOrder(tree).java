class preorder(tree){
//先序遍历的迭代形式
	public static void preOrderStack(TreeNode root) {
		 if (root == null) { 
	        return;
	    }
		stack<TreeNode> stack=new Stack<>();
		TreeNode curr=root;
		while(curr!=null||!stack.isEmpty()){
			while(curr!=null){
				System.out.println(curr.val);
				stack.push(curr);
				curr=curr.left;
			}
			curr=stack.pop();
			curr=curr.right;
		}
	}
	//另一种形式的先序遍历
	public static void preOrderStack1(TreeNode root) {
		if(root==null) return;
		stack<TreeNode> s=new Stack<>();
		s.push(root);
		while(!s.isEmpty()){
			root=s.pop();
			System.out.print(root.val);
			if(root.right!=null){
				s.push(root.right);
			}
			if(root.left!=null){
				s.push(root.left);
			}
		}

	}
}