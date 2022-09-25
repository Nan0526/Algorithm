package TwoPointers;

import java.util.PriorityQueue;

/*
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

Example 1:
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
 */

public class Hard407TrappingRainWaterII {

	//有一点问题 - 
    //问题在于 - 用priorityqueue - so 出来的会是最低的 - “默认poll的是“新那个？”周围的最矮的？？” - 怎么确定？ - 新的周围那个呢？ - 但是先放进去的周围的？ - 周围先放进pq最边上的？ - 但最边上的就一定比中间的高？？ - 
    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;
        public Cell(int r, int c, int h) {
            row = r;
            col = c;
            height = h;
        }
        
        public int compareTo(Cell otherCell) {
            if(this.height == otherCell.height) return 0;
            if(this.height > otherCell.height) return 1;
            return -1;
        }
    }
    
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length, n = heightMap[0].length;
        if(m < 1) return 0;
        
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < n; i++) {
            visited[0][i] = true;
            visited[m - 1][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            heap.offer(new Cell(m - 1, i, heightMap[m - 1][i]));
        }
        
        for(int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            heap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }
        
        int res = 0;
        while(!heap.isEmpty()) {
            Cell cur = heap.poll();
            int row = cur.row, col = cur.col, h = cur.height;
            
            for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                int r = row + dir[0];
                int c = col + dir[1];
                if(r > 0 && r < m - 1 && c > 0 && c < n - 1 && !visited[r][c]) {
                    visited[r][c] = true;
                    res += Math.max(0, h - heightMap[r][c]);
                    heap.offer(new Cell(r, c, Math.max(h, heightMap[r][c])));
                }
            }
        }
        
        return res;
    }
}