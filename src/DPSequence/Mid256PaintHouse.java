package DPSequence;

/*
 * There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain 
 * color is different. You have to paint all the houses such that no two adjacent houses have the same color.
The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.

For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
Return the minimum cost to paint all houses.

Example 1:
Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Example 2:
Input: costs = [[7,6,2]]
Output: 2
 */

public class Mid256PaintHouse {
	public int minCost(int[][] costs) {
        
        int len = costs.length;
        int[][] dp = new int[len + 1][3];
        
        for(int i = 1; i <= len; i++) { // <= len
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];//costs[i - 1][0]
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
            System.out.println(dp[i][0]);
        }
        
        return Math.min(Math.min(dp[len][0], dp[len][1]), dp[len][2]);
    }
}

//最值
/*
 * //use 滚动数组 rolling array
class Solution {
    public int minCost(int[][] costs) {
        
        int len = costs.length;
        int[][] dp = new int[2][3];
        int old = 0;
        int newN = 1;
        
        dp[old][0] = costs[0][0];
        dp[old][1] = costs[0][1];
        dp[old][2] = costs[0][2];
        
        if(len <= 1) {
            return Math.min(Math.min(dp[old][0], dp[old][1]), dp[old][2]);
        }
        
        for(int i = 1; i < len; i++) { // <= len
            
            dp[newN][0] = Math.min(dp[old][1], dp[old][2]) + costs[i][0];//costs[i - 1][0]
            dp[newN][1] = Math.min(dp[old][0], dp[old][2]) + costs[i][1];
            dp[newN][2] = Math.min(dp[old][1], dp[old][0]) + costs[i][2];
            if(i < len - 1) {
                dp[old][0] = dp[newN][0];
                dp[old][1] = dp[newN][1];
                dp[old][2] = dp[newN][2];
            }
        }
        
        return Math.min(Math.min(dp[newN][0], dp[newN][1]), dp[newN][2]);
    }
}
 *
 * */
