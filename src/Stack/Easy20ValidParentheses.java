package Stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 
Input: s = "()"
Output: true

Input: s = "()[]{}"
Output: true
 */


public class Easy20ValidParentheses {
	//then use stack
    public boolean isValid(String s) {
        char[] sArr = s.toCharArray();
        
        Deque<Character> stack = new LinkedList<>();
        
        for(int i = 0; i < sArr.length; i++) {
            if(stack.isEmpty() && (sArr[i] == ')' || sArr[i] == ']' || sArr[i] == '}')) {
                return false; 
            }else if(stack.isEmpty() || sArr[i] == '(' || sArr[i] == '[' || sArr[i] == '{') {
                stack.push(sArr[i]);
            }else if(stack.peek() == '(' && sArr[i] == ')') {
                stack.pop();
            }else if(stack.peek() == '[' && sArr[i] == ']') {
                stack.pop();
            }else if(stack.peek() == '{' && sArr[i] == '}') {
                stack.pop();
            }else {
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}


/*
first thought - using map - not working -
//passed some tests - but this can't: "([)]"
class Solution {
    public boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sArr = s.toCharArray();
        map.put('(', 0);
        map.put('[', 0);
        map.put('{', 0);
        
        if(sArr[0] == ')' ||sArr[0] == ']' || sArr[0] == '}') {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(sArr[i] == '(') {
                map.put('(', map.get('(') + 1);
            }
            if(sArr[i] == '[') {
                map.put('[', map.get('[') + 1);
            }
            if(sArr[i] == '{') {
                map.put('{', map.get('{') + 1);
            }
            if(sArr[i] == ')') {
                if(map.get('(') <= 0) {
                    return false;
                }else {
                    map.put('(', map.get('(') - 1);
                }
            }
            if(sArr[i] == ']') {
                if(map.get('[') <= 0) {
                    return false;
                }else {
                    map.put('[', map.get('[') - 1);
                }
            }
            if(sArr[i] == '}') {
                if(map.get('{') <= 0) {
                    return false;
                }else {
                    map.put('{', map.get('{') - 1);
                }
            }
        }
        
        for(Character n : map.keySet()) {
            if(map.get(n) != 0) {
                return false;
            }
        }
        return true;
    }
}
*/


