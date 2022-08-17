package TreeEasy;


/*
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:
Input: root = [1,2,2,3,4,4,3]
Output: true

Example 2:
Input: root = [1,2,2,null,3,null,3]
Output: false
 
Constraints:
The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100
 */

public class Easy101SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
        //需要left和right比较的 - 
        /*
        //dont need
        if(root == null) {
            return true;
        }
        */
        
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode a, TreeNode b) {
        if(a == null && b == null) {
            return true;
        }
        if(a == null || b == null) {
            return false;
        }
        if(a.val != b.val) {
            return false;
        }
        
        return check(a.left, b.right) && check(a.right, b.left);
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