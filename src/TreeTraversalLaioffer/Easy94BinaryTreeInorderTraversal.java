package TreeTraversalLaioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import TreeEasy.Easy111MinimumDepthOfBinaryTree.TreeNode;

/*
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.

Example 1:
Input: root = [1,null,2,3]
Output: [1,3,2]

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
//recursive //iterative
public class Easy94BinaryTreeInorderTraversal {
	List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return res;
        }
        
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }
}
*/


//iteratvie
class Solution {
  List<Integer> res = new ArrayList<>();
  public List<Integer> inorderTraversal(TreeNode root) {
      if(root == null) {
          return res;
      }
      
      Deque<TreeNode> stack = new ArrayDeque<>();
      //stack.offerFirst(root); - 不能先放 - 否则下面还进行还root操作 - 会遍历两遍
      TreeNode check = root;
      
      while(check != null || !stack.isEmpty()) {
          if(check != null) {
              stack.offerFirst(check);
              check = check.left;
          }else {
              check = stack.pollFirst();//当left走到最尽头 - check左孩为null - 开始打印root和探索right - （最后右元素 - 是在看完其左右子 都为null之后打印的）
              res.add(check.val);
              check = check.right; // 
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
//不太好 recursion- res.addAll
List<Integer> res = new ArrayList<>();
if(root == null) return res;
res.addAll(inorderTraversal(root.left));
res.add(root.val);
res.addAll(inorderTraversal(root.right));
return res;
*/
 

/*
//iterative - 同样逻辑 -先走left - 然后root right - 用while一left到底
public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> list = new ArrayList<Integer>();

  Stack<TreeNode> stack = new Stack<TreeNode>();
  TreeNode cur = root;

  while(cur!=null || !stack.empty()){
      while(cur!=null){
          stack.add(cur);
          cur = cur.left;
      }
      cur = stack.pop();
      list.add(cur.val);
      cur = cur.right;
  }

  return list;
}
*/

/*
//网上另 - iterative - 
public List<Integer> inorderTraversal(TreeNode root) {
  List<Integer> result = new ArrayList<>();
  Deque<TreeNode> stack = new ArrayDeque<>();
  TreeNode p = root;
  while(!stack.isEmpty() || p != null) {
      if(p != null) {
          stack.push(p);
          p = p.left;
      } else {
          TreeNode node = stack.pop();
          result.add(node.val);  // Add after all left children
          p = node.right;   
      }
  }
  return result;
}
*/
