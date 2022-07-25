package Others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

public class Easy1TwoSum {
	//way1 - HashMap
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

//way2 - two pointers
    /*
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Integer[] ind = new Integer[len];
        for(int i = 0; i < len; i++) ind[i] = i;
        Arrays.sort(ind, (l, r) -> nums[l] - nums[r]);
        int i = 0, j = len - 1;
        while(i < j) {
            int val = nums[ind[i]] + nums[ind[j]];
            if(val == target) return new int[] {ind[i], ind[j]};
            if(val < target) {
                i++;
            }
            else {
                j--;
            }
        }
        return new int[] {-1, -1};
    }
    */
}
