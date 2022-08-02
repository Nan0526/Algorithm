package DPSequence;
/*
 *There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by an n x k cost matrix costs.
For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
Return the minimum cost to paint all houses.

Example 1:
Input: costs = [[1,5,3],[2,9,4]]
Output: 5
Explanation:
Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

Example 2:
Input: costs = [[1,3],[2,4]]
Output: 5
 */

//最值
/*
//brute force
public class Hard265PaintHouseII {
	public int minCostII(int[][] costs) {
        //corner cases
        
        int n = costs.length;
        int K = costs[0].length;
        int[][] dp = new int[n][K];
    
        for(int i = 0; i < K; i++) {
            dp[0][i] = costs[0][i];
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < K; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < K; k++) {
                    if(k != j ) {
                        dp[i][j] = Math.min((dp[i - 1][k] + costs[i][j]), dp[i][j]);
                    }
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i< K; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
*/


//rolling array
//注意：不应该在第二层j换dp[old] - 不然不行- 因为未遍历完的NewN可能还要用未修改的old
//滚动数组看len - 小于1
class Solution {
    public int minCostII(int[][] costs) {
        //corner cases
        
        int n = costs.length;
        Integer K = costs[0].length;
        
        int[][] dp = new int[2][K];
        
        int old = 0;
        int newN = 1;
        
        for(int i = 0; i < K; i++) {
            dp[old][i] = costs[old][i];
            //System.out.println(dp[old][i]);
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < K; j++) {
                dp[newN][j] = Integer.MAX_VALUE;
                for(int k = 0; k < K; k++) {
                    if(k != j ) {
                        dp[newN][j] = Math.min((dp[old][k] + costs[i][j]), dp[newN][j]);
                        
                    }
                }
                //不应该在这换dp[old] - 不然不行- 因为未遍历完的NewN可能还要用未修改的old
                /*
                //错的
                if(i == 1) {
                    System.out.println(dp[newN][j]);
                }
                dp[old][j] = dp[newN][j]; 
                */
            } 
            for(int j = 0; j < K; j++) {
                dp[old][j] = dp[newN][j];
            }
        }
        
        int res = Integer.MAX_VALUE;
        //滚动数组记得cornercase出n<=1的情况
        
        for(int i = 0; i< K; i++) {
            if(n > 1) {
                res = Math.min(res, dp[newN][i]);
            }else {
                res = Math.min(res, costs[0][i]);
            }
            
        }
        return res;
    }
}


