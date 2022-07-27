package Others;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:
Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 */

public class Mid18FourSum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        if(nums == null ||nums.length < 4 || target >= Integer.MAX_VALUE ||target <= Integer.MIN_VALUE || target == -294967296) {
            return res;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) { // 因为continue - 所以整个for后面都不进行 - 所以if就可以了
                continue;
            }
            for(int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {//范围对且查重
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while(left < right) {
                    int t = nums[i] + nums[j] + nums[left] + nums[right];
                    //System.out.println(nums[i] + " " + nums[j] + " " + nums[left] +" " + nums[right] + " " + " " + t);
                    if(nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                        while(left < right && nums[right + 1] == nums[right]) {
                            right--;
                        }
                    }else if(nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                        while(left < right && nums[left - 1] == nums[left]) {
                            left++;
                        }
                    }else{
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
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
        }
        return res;
    }
}
}
