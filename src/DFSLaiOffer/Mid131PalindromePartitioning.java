package DFSLaiOffer;

import java.util.LinkedList;
import java.util.List;

/*
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

Example 1:
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 */

//Similar - to Combination
public class Mid131PalindromePartitioning {

	public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<>();
        List<String> list = new LinkedList<>();
        dfs(res, list, s, 0);
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, String s, int index) {
        if(index == s.length()) {
            res.add(new LinkedList<>(list));
        } 
        
        for(int i = index; i < s.length(); i++) {
            if(isPal(s, index, i)) {
                list.add(s.substring(index, i + 1));
                dfs(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPal(String s, int low, int hi) {
        while(low < hi) {
            if(s.charAt(low) != s.charAt(hi)) {
                return false;
            }
            low++;
            hi--;
        }
        return true;
    }
}

