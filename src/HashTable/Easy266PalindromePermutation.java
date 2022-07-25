package HashTable;

/*
 * Given a string s, return true if a permutation of the string could form a palindrome.

Input: s = "code"
Output: false

Input: s = "aab"
Output: true
 */

public class Easy266PalindromePermutation {
	//also can use hashtable
    public boolean canPermutePalindrome(String s) {
        //using map
        char[] sArr = s.toCharArray();
        int[] letters = new int[26];
            
        for(int i = 0; i < sArr.length; i++) {
            letters[sArr[i] - 97]++;
        }
        
        int check = 0;
        for(int i : letters) {
            if(i % 2 != 0) {
                check++;
            }
        }
        if(check > 1) return false;
        return true;
    }
}
