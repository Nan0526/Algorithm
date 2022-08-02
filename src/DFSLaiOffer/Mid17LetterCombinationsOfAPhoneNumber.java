package DFSLaiOffer;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
 * Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 
Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

//Combinations
public class Mid17LetterCombinationsOfAPhoneNumber {

	List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) {
            return res;
        }
    
        /*
        //可用easier way
        Map<Character, char[]> map = new HashMap<>();
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        */
        
        dfs(digits, 0);
        
        return res;
    }
    
    private void dfs(String digits, int index) {
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        for(char c : letter[digits.charAt(index) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}