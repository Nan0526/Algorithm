package DPYesOrNo;

/*
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.
Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump in the forward direction.

Example 1:
Input: stones = [0,1,3,5,6,8,12,17]
Output: true
Explanation: The frog can jump to the last stone by jumping 1 unit to the 2nd stone, then 2 units to the 3rd stone, then 2 units to the 4th stone, then 3 units to the 6th stone, 4 units to the 7th stone, and 5 units to the 8th stone.

Example 2:
Input: stones = [0,1,2,3,4,8,9,11]
Output: false
Explanation: There is no way to jump to the last stone as the gap between the 5th and 6th stone is too large.
 
Constraints:
2 <= stones.length <= 2000
0 <= stones[i] <= 231 - 1
stones[0] == 0
stones is sorted in a strictly increasing order.
 */


//two things are important:
//stone position && k - 
//得先找到隐藏条件 - 在i块石头时 - 最多跳i+1下
class Hard403FrogJump2D {
  public boolean canCross(int[] stones) {
      
      int len = stones.length;
      
      boolean[][] dp = new boolean[len][len];
      dp[0][0] = true;
      
      for(int i = 1; i < len; i++) {
          if(stones[i] - stones[i - 1] > i) { // 如果每一步超过最大跳跃
              return false;
          }
          
          for(int j = i - 1; j >= 0; j--) {
              int k = stones[i] - stones[j];
              if(k > j + 1) {
                  continue;//no more than the biggest
              }
              
              dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
          }
      }
      
      for(int i = 0; i < len; i++) {
          if(dp[len - 1][i]) {
              return true;
          }
      }
      
      return false;
  }
}
  
  
  
/*
if(stones[1] - stones[0] > 1) {
          return false;
      }else {
          dp[0] = true;
          dp[1] = true;
      }
      
      int k = 1;
      for(int i = 2; i < len; i++) {
          for(int j = 0; j < i; j++) {
              int dif = stones[i] - stones[j];
              if(dp[j] && (dif == k || dif == k - 1 || dif == k + 1)) {
                  dp[j] = true;
                  k = dif;
                  System.out.println(k);
                  break;
              }
          }
      }
      
      return dp[len - 1];
  }
*/