package DFSLaiOffer;


import java.util.LinkedList;
import java.util.List;

/*
Given an integer array nums of unique elements, return all possible subsets (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 */

public class Mid78SubSets {
	
	public List<List<Integer>> subsets(int[] nums) {
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
        
        //for(int i = 0; i < nums.length; i++) { no need - recursion already did forloop
            list.add(nums[index]);
            dfs(nums, res, list, index + 1);
            list.remove(list.size() - 1);
            dfs(nums, res, list, index + 1); // 不要用++
        //}        
    }
}
