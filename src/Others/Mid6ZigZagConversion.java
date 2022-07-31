package Others;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display 
 * this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
string convert(string s, int numRows);

Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
 */

public class Mid6ZigZagConversion {

	public String convert(String s, int numRows) {
        //corner case
        
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }
        
        char[] sA = s.toCharArray();
        
        //loop the s - 1 down straight & 2 up to the next col
        //i - for stringbuilder index && index for the char in the string
        int index = 0;
        int len = sA.length;
        while(index < len) {
            for(int i = 0; i < numRows && index < len; i++) {
                sb[i].append(sA[index++]);
            }
            
            for(int i = numRows - 2; i > 0 && index < len; i--) {
                sb[i].append(sA[index++]);
            }
        }
        
        for(int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }
        
        return sb[0].toString();
    }
}