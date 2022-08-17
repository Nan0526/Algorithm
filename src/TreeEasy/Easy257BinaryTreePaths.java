package TreeEasy;

import java.util.LinkedList;
import java.util.List;

public class Easy257BinaryTreePaths {
	List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null) dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        int len = sb.length();
        sb.append(root.val);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
            sb.setLength(len);
            return;
        }
        
        sb.append("->");
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);
        sb.setLength(len);
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
//+debug - System.out.println
class Solution {
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root != null) dfs(root);
        return res;
    }
    
    private void dfs(TreeNode root) {
        int len = sb.length();
        //System.out.println(len + "a" );
        sb.append(root.val);
        //System.out.println(sb);
        if(root.left == null && root.right == null) {
            res.add(sb.toString());
            sb.setLength(len);
            return;
        }
        
        sb.append("->");
        if(root.left != null) dfs(root.left);
        // sb.setLength(len);
        // sb.append("->");
        if(root.right != null) dfs(root.right);
        sb.setLength(len);
    }
}
*/