package DP;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

public class Mid139WordBreak {

	//背包问题
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        char[] sA = s.toCharArray();
        boolean[] dp = new boolean[sA.length + 1];
        dp[0] = true;
        
        
        for(int i = 1; i <= sA.length; i++) {
            for(int j = 0; j < i; j++) {
                if(set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    //break; - 无论如何- 走完也罢 - 不会再变回false
                }
            }
        }
        
        return dp[sA.length];
    }
}