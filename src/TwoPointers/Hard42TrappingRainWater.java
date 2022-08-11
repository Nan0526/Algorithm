package TwoPointers;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water 
(blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

public class Hard42TrappingRainWater {

	public int trap(int[] height) {
        //corner case - valid
        
        int len = height.length;
        int[] leftScan = new int[len];
        int[] rightScan = new int[len];
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++) {
            max = Math.max(max, height[i]);
            leftScan[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        for(int i = len - 1; i >= 0 ; i--) {
            max = Math.max(max, height[i]);
            rightScan[i] = max;
            //System.out.print(rightScan[i] + " ");
        }
        
        int res = 0;
        for(int i = 0; i < len; i++) {
            if(Math.min(leftScan[i], rightScan[i]) > height[i]) { //简单看下合法性
                res += Math.min(leftScan[i], rightScan[i]) - height[i];
            }
        }
        
        return res;
    }
}