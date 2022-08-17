package TreeTraversalLaioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
 */


//expand from binary tree preorder traversal
//recursive & iteratvie
//N-ary Tree没有inorder - 不知道在哪个child之后弄root - 基本Nary就是graph
public class Easy589NaryTreePreOrderTraversal {

	//iterative
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) {
            return res;
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while(!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            res.add(cur.val);
            
            if(cur.children != null) {
                for(int i = cur.children.size() - 1; i >= 0; i--) {
                    stack.offerFirst(cur.children.get(i));
                }
            }
        }
        
        return res;
    }
    
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
}


/*
class Solution {
  //recursive
  List<Integer> res = new ArrayList<>();
  public List<Integer> preorder(Node root) {
      if(root == null) {
          return res;
      }
      
      res.add(root.val);
      for(int i = 0; i < root.children.size(); i++) {
          preorder(root.children.get(i));
      }
      
      return res;
  }
}
*/

