package TreeTraversalLaioffer;

import java.util.ArrayList;
import java.util.List;

import TreeTraversalLaioffer.Easy145BinaryTreePostorderTraversal.TreeNode;

/*
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,2,3]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

public class Easy144BinaryTreePreorderTraversal {
	List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        res.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return res;
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

