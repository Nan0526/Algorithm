package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
 */

public class Hard140WordBreakII {

	//return all the results - dfs
    //像是laioffer的combination --- 
    List<String> res = new ArrayList<>();
    Set<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        
        //check - if the letters in s is not in wordDict - then can't form anything
        //不要弄反 - wordDict放进check - 然后检查s
        int[] check = new int[26];
        for(char c : s.toCharArray()) {
                check[c - 'a']++;
        }
        
        for(String word : wordDict) {
            for(char c : word.toCharArray()) {
                check[c - 'a']++;
            }
        }
        
        for(char c : s.toCharArray()) {
            if(check[c - 'a'] == 0) {
                return res;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        dfs(s, set, 0, sb);
        return res;
    }
    
    private void dfs(String s, Set<String> set, int index, StringBuilder sb) {
        //base case
        if(index == s.length()) {
            //System.out.print("a"); - 没进来
            //System.out.print(sb);
            res.add(sb.toString());
            //System.out.print(res);
            return;
        }
        
        for(int i = index; i < s.length(); i++) {
            System.out.print(i);
            if(set.contains(s.substring(index, i + 1))) {
                int before = sb.length();
                if(sb.length() == 0) {
                    sb.append(s.substring(index, i + 1));
                }else {
                    sb.append(" ");
                    sb.append(s.substring(index, i + 1));
                }
                
                dfs(s, set, i + 1, sb);
                //backtracking
                sb.delete(before, sb.length());
            }
        }
    }
}