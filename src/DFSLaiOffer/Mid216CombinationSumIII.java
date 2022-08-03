package DFSLaiOffer;

import java.util.LinkedList;
import java.util.List;

/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 

Constraints:

2 <= k <= 9
1 <= n <= 60
 */

public class Mid216CombinationSumIII {

	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        dfs(res, list, n, k, 1, 0);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> list, int left, int num, int start, int index) {
        if(num == 0) {
            if(left == 0) {
                res.add(new LinkedList<>(list));
                return;
            }
        }
        
        
        for(int i = start; i <= 9; i++) {// index和start还不一样 - 因为之前不要求个数- 现在要求个数
            list.add(i);
            dfs(res, list, left - i, num - 1, i + 1, index + 1);
            list.remove(list.size() - 1);
        }
    }
}



