package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t 
 * (including duplicates) is included in the window. If there is no such substring, return the empty string "".
The testcases will be generated such that the answer is unique.
A substring is a contiguous sequence of characters within the string.

Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
 */

//问题 - count有增加？？ - 没减少？？？ - 
public class Hard76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        //先把t都放进map里
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //sliding window 维持这样的一个window - 包含所有t的元素 - 然后最短
        int slow = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int fast = 0; fast < s.length(); fast++) {
            char fC = s.charAt(fast);
            if(!map.containsKey(fC)) {
                continue;
            }
            //刚好可以抹去t中相应的值
            if(map.get(fC) == 1) {
                count++;
            }
            map.put(fC, map.get(fC) - 1);
            
            //slow移动 - 使slow fast之间是合理的且当前fast下最小的-- map里边不包含slow对应的元素-t里无 或者slow对应的map里边的小于0-subarray扣减的超了
            while(!map.containsKey(s.charAt(slow)) || map.get(s.charAt(slow)) < 0) {//或者不包含slow的 或者slow那边的char已经两个or以上
                char cS = s.charAt(slow++);
                if(map.containsKey(cS)) {//还是要单拎出来 - map.get(.charAt(slow)) < 0对应的内容
                    map.put(cS, map.get(cS) + 1); //-- 为了让其有变成0的可能性
                    
                }
            }
            
            //到达一个合理的地方 - 可以generate答案了
            if(count == map.size() && min > fast - slow + 1) {
                min = fast - slow + 1;
                res = s.substring(slow, fast + 1);
            }
        }
        return res;
    }
}



/*
//有点问题呵呵呵 - 
class Solution {
    public String minWindow(String s, String t) {
        //put t all in check
        int[] check = new int[26];
        for(char c : t.toCharArray()) {
            check[c - 'A']++;
        }
        
        //sliding window 维持这样一个window - 包含所有t元素 - 然后最短
        int slow = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        String res = "";
        
        for(int fast = 0; fast < s.length(); fast++) {
            char f = s.charAt(fast);
            //不包含？
            if(check[f - 'A'] == 0) {
                continue;
            }
            
            if(check[f - 'A'] == 1) {
                count++;
            }
            check[f - 'A']--;
            
            char cS = s.charAt(slow);
            while(check[cS - 'A'] <= 0) {
                if(check[cS - 'A'] > 0) {
                    count--;
                }
                slow++;
                check[cS - 'A']++;
            }
            
            
            if(count == t.length() && min > fast - slow + 1) {
                min = fast - slow + 1;
                res = s.substring(slow, fast + 1);
            }
        }
        return res;
    }
}
*/


/*
class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        //先把t都放进map里
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //sliding window 维持这样的一个window - 包含所有t的元素 - 然后最短
        int slow = 0;
        int count = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        for(int fast = 0; fast < s.length(); fast++) {
            char fC = s.charAt(fast);
            if(!map.containsKey(fC)) {
                continue;
            }
            //刚好可以抹去t中相应的值
            if(map.get(fC) == 1) {
                count++;
            }
            map.put(fC, map.get(fC) - 1);
            
            //slow移动 - 使slow fast之间是合理的且当前fast下最小的-- map里边不包含slow对应的元素 或者slow对应的map里边的小于0
            while(!map.containsKey(s.charAt(slow)) || map.get(s.charAt(slow)) < 0) {//或者不包含slow的 或者slow那边的char已经两个or以上
                char cS = s.charAt(slow++);
                if(map.containsKey(cS)) {//还是要单拎出来 - map.get(.charAt(slow)) < 0对应的内容
                    map.put(cS, map.get(cS) + 1); //-- 为了让其有变成0的可能性
                }
            }
            
            //到达一个合理的地方 - 可以generate答案了
            if(count == map.size() && min > fast - slow + 1) {
                min = fast - slow + 1;
                res = s.substring(slow, fast + 1);
            }
        }
        return res;
    }
}
*/