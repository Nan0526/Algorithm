package DfsMatrixBfs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all 
four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 */

//bfs
public class Mid200NumberOfIslands {

	//用visited或者换数字都行
    public int numIslands(char[][] grid) {
        int num = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    num++;
                    grid[i][j] = '2';
                    bfs(grid, i, j);
                }
            }
        }
        return num;
    }
    
    //可以放 int[] 或者 i*cols+j
    private void bfs(char[][] grid, int i, int j) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
                        grid[x][y] = '2';
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }        
    }
}

/*
//dfs
class Solution {
  //用visited或者换数字都行
  public int numIslands(char[][] grid) {
      int num = 0;
      for(int i = 0; i < grid.length; i++) {
          for(int j = 0; j < grid[0].length; j++) {
              if(grid[i][j] == '1') {
                  num++;
                  grid[i][j] = '2';
                  dfs(grid, i, j);
              }
          }
      }
      return num;
  }
  
  private void dfs(char[][] grid, int i, int j) {
      
      for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
          int x = i + dir[0];
          int y = j + dir[1];
          if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1') {
              grid[x][y] = '2';
              dfs(grid, x, y);
          }
      }
  }
}
*/