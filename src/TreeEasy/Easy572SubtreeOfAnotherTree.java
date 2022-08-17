package TreeEasy;

import TreeEasy.Easy543DiameterOfBinaryTree.TreeNode;

/*
 * Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same 
 * structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. 
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
 */

//有点像BalancedBinaryTree
//recursive - 
//iterative下面的 - 用不同方式遍历全部的root树对应的node
public class Easy572SubtreeOfAnotherTree {

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if(root == null || subRoot == null) {
            return false;
        }
        if(isSame(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.val != t.val) { //不能 == -> return true
            return false; //因为可能还没到最后 - 一个相同不能说明是true - 但一个错 - 则错
        }
        
        return isSame(s.left, t.left) && isSame(s.right, t.right);
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        Queue<TreeNode>q=new LinkedList<>();
        q.add(s);
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(isSame(node,t))
                    return true;
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
        }
        return false;
        
    }
    public boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null)
            return true;
        else if(s == null || t == null)
            return false;
        else if(s.val != t.val)
            return false;
        else
            return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
*/

