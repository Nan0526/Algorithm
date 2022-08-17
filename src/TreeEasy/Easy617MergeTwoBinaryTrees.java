package TreeEasy;

/*
 * You are given two binary trees root1 and root2.
Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
Return the merged tree.
Note: The merging process must start from the root nodes of both trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:
Input: root1 = [1], root2 = [1,2]
Output: [2,2]
 */

public class Easy617MergeTwoBinaryTrees {

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        if(root1 == null || root2 == null) {
             // 两个都算base case - 不算其中情况？也算是 - 终极逻辑是的 - 则其中逻辑也是
            /*
            int val = root1 == null ? root2.val : root1.val;
            root = new TreeNode(val);
            if(root1 == null ) root.left = mergeTrees(null, root2.left);
            if(root2 == null) root.right = mergeTrees(root1.right, null);
            return root;
            */
            
            return root1 == null ? root2 : root1;
            
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
	
	public class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode() {}
	    TreeNode(int val) { this.val = val; }
	    TreeNode(int val, TreeNode left, TreeNode right) {
	        this.val = val;
	        this.left = left;
	        this.right = right;
	    }
	}
}