package DFSLaiOffer;

import java.awt.List;
import java.util.LinkedList;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]
 */


public class Mid22GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        dfs(n, res, sb, 0, n, n);
        return res;
    }
    
    private void dfs(int n, List<String> res, StringBuilder sb, int index, int left, int right) {
        if(index == 2*n) {
            res.add(sb.toString());
            return;
        }
        
        if(left > 0) {
            sb.append('(');
            dfs(n, res, sb, index + 1, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right > left) {
            sb.append(')');
            dfs(n, res, sb, index + 1, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
