package DFSLaiOffer;

import java.util.LinkedList;
import java.util.List;

/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
 */

public class Mid39CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(candidates, target, res, list, 0);
        return res;
    }
    
    private void dfs(int[] candidates, int left, List<List<Integer>> res, List<Integer> list, int index) {
        if(left == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if(left < 0) return;
        
        for(int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, left - candidates[i], res, list, i); // i
            //因为边界结束条件不同 - 这题是看index层数 / combination sum是看的总和和剩的数
            list.remove(list.size() - 1);
        }
    }
}
