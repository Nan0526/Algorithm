package TreeTraversalLaioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


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


/*
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
}
*/


/*
//iteratvie - using Deque - 物理意义stack
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            res.add(cur.val);
            
            if(cur.right != null) {
                stack.offerFirst(cur.right);
            }
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
        }
        
        return res;
    }
}
*/


//Iterative - using Stack
class Easy144BinaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            
            if(cur.right != null) {
                stack.add(cur.right);
            }
            if(cur.left != null) {
                stack.add(cur.left);
            }
        }
        
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


/*
//另一 - 网上
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.add(p.val);  // Add before going to children
            p = p.left;
        } else {
            TreeNode node = stack.pop();
            p = node.right;   
        }
    }
    return result;
}
*/



