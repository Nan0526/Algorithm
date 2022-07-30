package DfsMatrixBfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left 
 * and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height 
above sea level of the cell at coordinate (r, c).
The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring 
cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific 
and Atlantic oceans.

Example 1:
Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 */

public class Mid417PacificAtlanticWaterFlow {

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
        //Expande from Pacific side & Expand from Atlantic side - 'Number of Island'
        //Iterate from top and bottom / from left and right edges
        //If the next direction(4) is bigger or equal to this - expand - 
        //Use Visited int[][]- 0-1-2 - (Use 2 boolean[][]- 走过的路标记为True - 两边交汇，都是true的ok)   
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        //from top and bottom
        for(int i = 0; i < n; i++) {
            dfs(heights, pacific, 0, i);
            dfs(heights, atlantic, m - 1, i);
        }
        
        //from left & right
        for(int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        
        List<List<Integer>> res = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res; 
    }

    
    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;

        for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int x = row + dir[0];
            int y = col + dir[1];
            if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !ocean[x][y] && heights[x][y] >= heights[row][col]) {
                ocean[x][y] = true;
                dfs(heights, ocean, x, y);
            }
        }
    }
    
    /*
    private void bfs(int[][] heights, boolean[][] ocean, int row, int col) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                ocean[i][j] = true;
                
                for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !ocean[x][y] && heights[x][y] >= heights[i][j]) {
                        ocean[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
    */
    
    
}

