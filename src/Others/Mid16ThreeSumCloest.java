package Others;

import java.util.Arrays;

/*
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.

Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class Mid16ThreeSumCloest {

	public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target) {
                    return target;
                }else if(sum > target) {
                    right--;
                }else {
                    left++;
                }
                
                if(Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
            }
        }
        return res;
    }
}