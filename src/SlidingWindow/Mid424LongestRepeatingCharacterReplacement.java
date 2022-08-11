package SlidingWindow;

/*
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
 */

public class Mid424LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
        //corner case
        
        int slow = 0;
        int max = 0;
        int len = 0;
        //Map<Character, Integer> map = new HashMap<>();
        int[] check = new int[26];
        
        for(int fast = 0; fast < s.length(); fast++) {
            check[s.charAt(fast) - 'A']++;
            int count = check[s.charAt(fast) - 'A'];
            max = Math.max(max, count);
            
            while(fast - slow + 1 - max > k) { //保证无论如何subarray长度不超过max+k - 然后在这个范围内都可以变换k次内 - 
                check[s.charAt(slow++) - 'A']--;
            }
            
            //map.put();
            len = Math.max(len, fast - slow + 1);
        }
        return len;
    }
}
