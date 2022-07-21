package DFSLaiOffer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */

public class Mid40CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, res, list, 0);
        return res;
    }
    
    //基本同I - 之前可以无限使用任何数 - so i可以每次不断延后 - 现在还是得这样 - 不过是当前i之后的一个数字
    private void dfs(int[] candidates, int left, List<List<Integer>> res, List<Integer> list, int index) {
        if(left == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if(left < 0) return;
        
        for(int i = index; i < candidates.length; i++) {
            //same position just put one same number - to avoid same-order duplicates 
            if(i > index && candidates[i] == candidates[i - 1]) {
                continue; //should be continue - not i++
            }
            list.add(candidates[i]);
            dfs(candidates, left - candidates[i], res, list, i + 1);//i+1还是之前的循环
            list.remove(list.size() - 1);
        }
    }
}
