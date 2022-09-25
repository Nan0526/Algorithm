package BinarySearch;

import java.util.Arrays;

/*
Given an array nums which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous 
subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.

 

Example 1:

Input: nums = [7,2,5,10,8], m = 2
Output: 18
Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
 */

public class Hard410SplitArrayLargestSum{

	//跟1011很像 - 都是提炼出capacity(subarrySum) - 然后binary search去试 - 左边不行右边行 - helper function来表示isValid是否boolean
    public int splitArray(int[] nums, int m) {
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        
        return binarySearch(nums, m, sum, max);
    }
    
    private int binarySearch(int[] nums, int m, int high, int low) {
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(isValid(nums, m, mid)) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    } 
    
    private boolean isValid(int[] nums, int m, int capacity) {
        int sum = 0;
        int count = 1;
        
        for(int i = 0; i < nums.length; i++) {
            
            sum += nums[i];
            if(sum > capacity) {
                count++;
                sum = nums[i];
            }
            if(count > m){
                return false;
            }
        }
        return true;
    }
}