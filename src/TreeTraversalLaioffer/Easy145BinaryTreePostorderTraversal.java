package TreeTraversalLaioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/*
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [3,2,1]

Example 2:
Input: root = []
Output: []

Example 3:
Input: root = [1]
Output: [1]
 
Constraints:
The number of the nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

/*
//recursive
public class Easy145BinaryTreePostorderTraversal {
	List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
*/


class Easy145BinaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<TreeNode> reverse = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while(!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            reverse.offerFirst(cur);
            
            if(cur.left != null) {
                stack.offerFirst(cur.left);
            }
            if(cur.right != null) {
                stack.offerFirst(cur.right);
            }
        }
    
        while(!reverse.isEmpty()) {
            res.add(reverse.pollFirst().val);
        }
        /* - same
        int size = reverse.size();
        for(int i = 0; i < size; i++) {//不能用size操作！！
            res.add(reverse.pollFirst().val);
        }
        */
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
//网上 - iteratvie 方法
public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(!stack.isEmpty() || p != null) {
        if(p != null) {
            stack.push(p);
            result.addFirst(p.val);  // Reverse the process of preorder
            p = p.right;             // Reverse the process of preorder
        } else {
            TreeNode node = stack.pop();
            p = node.left;           // Reverse the process of preorder
        }
    }
    return result;
}

*/