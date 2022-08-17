package TreeEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Given the root of a binary search tree (BST) with duplicates, return all the mode(s) (i.e., the most frequently occurred element) in it.
If the tree has more than one mode, return them in any order.

Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
 
Example 1:
Input: root = [1,null,2,2]
Output: [2]

Example 2:
Input: root = [0]
Output: [0]
 
Constraints:
The number of nodes in the tree is in the range [1, 104].
-105 <= Node.val <= 105

 */

public class Easy501FindModeInBinarySearchTree {

	Map<Integer, Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int n : map.keySet()) {
            if(map.get(n) > max) {
                max = map.get(n);
                list.clear();
            }
            if(map.get(n) == max) {
                list.add(n);
            }
        }
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        dfs(root.left);
        dfs(root.right);
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