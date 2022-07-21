package DFSLaiOffer;
import java.util.LinkedList;
import java.util.List;

/*
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
You may return the answer in any order.


Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

Input: n = 1, k = 1
Output: [[1]]
 */

public class Mid77Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(n, k, res, list, 0, 1);
        return res;
    }
    
    private void dfs(int n, int k, List<List<Integer>> res, List<Integer> list, int index, int cur) {
        if(index == k) {
            res.add(new LinkedList<>(list));
            return;
        }
        
        //Just changing 'i', not index - index will change along with the dfs - i will change in current index level
        //因为边界结束条件不同 - 这题是看index层数 / combination sum是看的总和和剩的数
        for(int i = cur; i <= n; i++) {
            list.add(i);
            dfs(n, k, res, list, index + 1, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
