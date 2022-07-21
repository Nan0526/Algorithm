package DFSLaiOffer;
import java.util.LinkedList;
import java.util.List;
/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Input: nums = [0,1]
Output: [[0,1],[1,0]]

 */

public class Mid46Permutations {
	List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new LinkedList<>();
        dfs(nums, 0, list);
        return res;
    }
    
    private void dfs(int[] nums, int index, List<Integer> list) {
        if(index == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        for(int i = index; i < nums.length; i++) {
            
            list.add(nums[i]);
            swap(nums, index, i);//first add then swap - or will change the -会少了第一个跟position index的index一样的letter
            dfs(nums, index + 1, list);
            
            swap(nums, index, i);
            list.remove(list.size() - 1);
        }
        
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
