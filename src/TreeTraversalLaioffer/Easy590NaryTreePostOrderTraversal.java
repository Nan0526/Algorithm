package TreeTraversalLaioffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Given the root of an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]
 */

//iterative
public class Easy590NaryTreePostOrderTraversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return res;
        }
        
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> reverse = new ArrayDeque<>();
        stack.offerFirst(root);
        
        while(!stack.isEmpty()) {
            Node cur = stack.pollFirst();
            reverse.offerFirst(cur);
            
            if(cur.children != null) {
                for(int i = 0; i < cur.children.size(); i++) {
                    stack.offerFirst(cur.children.get(i));
                }
            }
        }
        
        //reverse
        while(!reverse.isEmpty()) {
            res.add(reverse.pollFirst().val);
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
//recursive
class Solution {
    //recursive
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return res;
        }
        
        for(int i = 0; i < root.children.size(); i++) {
            postorder(root.children.get(i));
        }
        res.add(root.val);
        
        return res;
    }
}
*/