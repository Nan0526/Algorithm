package DFSLaiOffer;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

public class Mid47PermutationsII {
	List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new LinkedList<>();
        dfs(nums, 0, list);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        Set<Integer> set = new HashSet<>(); //每层一个hashset - 可以说每次分叉头 往下分的时候一个set - 以确保这一层这一叉没重复
        for(int i = index; i < nums.length; i++) {
            if(set.add(nums[i])) {
                list.add(nums[i]);
                swap(nums, index, i);
                dfs(nums, index + 1, list);
                list.remove(list.size() - 1);
                swap(nums, index, i);
            }
        }
        
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
