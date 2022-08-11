package SlidingWindow;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
 */

public class Mid3LongestSubstringWithoutRepeatingCharacters {
	//sliding window
    //模版 - 
	public static void main(String[] args) {
		
		Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set1.add(6);
        System.out.println(set1);
	}
	
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
              
        Map<Integer, Integer> map = new TreeMap<>();
        
        
        for(int fast = 0; fast < s.length(); fast++) {
            char f = s.charAt(fast);
            while(set.contains(f)) {
                set.remove(s.charAt(slow++));
            }
            set.add(f);
            max = Math.max(max, fast - slow + 1);
        }
        return max;
    }
}

