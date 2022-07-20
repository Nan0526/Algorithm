package DFSLaiOffer;

import java.util.Arrays;
import java.util.LinkedList;

/*
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

public class Mid90SubSetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);//Important!
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(nums, res, list, 0);
        return res;
    }
    
    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, int index) {
        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        int level = index; // level - store the first one of the (duplicates)
        list.add(nums[level]);
        dfs(nums, res, list, level + 1);
        list.remove(list.size() - 1);
        while(index < nums.length && nums[index] == nums[level]) { // operate 'not add' & keep index to next number
            index++;
        }
        dfs(nums, res, list, index); // 不要用++
     
    }
}
