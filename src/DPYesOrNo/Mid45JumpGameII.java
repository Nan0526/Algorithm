package DPYesOrNo;

/*
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.
Your goal is to reach the last index in the minimum number of jumps.
You can assume that you can always reach the last index.

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
 */

public class Mid45JumpGameII {

	public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++) {
                if(dp[j] >= 0 && nums[j] >= i - j) { // >= 0 因为表示第一步 - 因为assume总能跳到最后
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
            System.out.println(dp[i]);
        }
        
        return dp[len - 1];
    }
}