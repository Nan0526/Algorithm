package TreeEasy;


/*
 * Given the root of a binary search tree and a target value, return the value in the BST that is closest to the target.

Example 1:
Input: root = [4,2,5,1,3], target = 3.714286
Output: 4

Example 2:
Input: root = [1], target = 4.428571
Output: 1

Constraints:
The number of nodes in the tree is in the range [1, 104].
0 <= Node.val <= 109
-109 <= target <= 109
 */


//recursive
public class Easy270CloestBinarySearchTreeValue {

	int close;
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        close = root.val;
        dfs(root, target);
        return close;
    }
    
    private void dfs(TreeNode root, double target) {
        if(root == null) return;
        
        if(Math.abs(target - root.val) < Math.abs(target - close)) {
            close = root.val;
        }
        if(root.val > target) dfs(root.left, target);
        if(root.val < target) dfs(root.right, target);
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
//iterative
class Solution {
  public int closestValue(TreeNode root, double target) {
      int close = root.val;
      
      while(root != null) {
          if(Math.abs(target - root.val) < Math.abs(target - close)) {
              close = root.val;
          }
          root = root.val > target ? root.left : root.right;
      }
      
      return close;
  }
}
*/
