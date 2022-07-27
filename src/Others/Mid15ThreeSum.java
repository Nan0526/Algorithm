package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, 
 * and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */

public class Mid15ThreeSum {
	//deduplicate - very important
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null ||nums.length < 3) {
            return res;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                    while(left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                }else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    while(left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    res.add(list);

                    left++;
                    right--;
                    while(left < right && nums[right + 1] == nums[right]) {
                        right--;
                    }
                     while(left < right && nums[left - 1] == nums[left]) {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
