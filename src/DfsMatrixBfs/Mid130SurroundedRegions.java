package DfsMatrixBfs;

/*
 * Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example 1:
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Notice that an 'O' should not be flipped if:
- It is on the border, or
- It is adjacent to an 'O' that should not be flipped.
The bottom 'O' is on the border, so it is not flipped.
The other three 'O' form a surrounded region, so they are flipped.
Example 2:


 */

public class Mid130SurroundedRegions {

	public void solve(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if((i == 0 || i == board.length - 1 || j == 0 ||j == board[0].length - 1) && board[i][j] == 'O') {
                    board[i][j] = 'A';
                    dfs(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int i, int j) {
        
        for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O') {
                board[x][y] = 'A';
                dfs(board, x, y);
            }
        }
    }
}



/*
//bfs
class Solution {
  public void solve(char[][] board) {
      //正确思路
      //1 - find all Os in the four boarder - change to A - and BFS to generate all board Os to As
      //2 - change O to X and A to O
      
      //corner cases - legal - 
      
      int rows = board.length;
      int cols = board[0].length;
      //1 - find all Os in the four boarder - change to A - and BFS to generate all board Os to As
      for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
              if((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O') {
                  board[i][j] = 'A';
                  bfs(board, i, j);
              }
          }
      }
      
      //2 - change O to X and A to O
      for(int i = 0; i < rows; i++) {
          for(int j = 0; j < cols; j++) {
              if(board[i][j] == 'O') {
                  board[i][j] = 'X';
              }
              if(board[i][j] == 'A') {
                  board[i][j] = 'O';
              }
          }
      }
      
  }
  
  private void bfs(char[][] board, int i, int j) {
      int rows = board.length;
      int cols = board[0].length;
      
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i*cols + j);
      
      while(!queue.isEmpty()) {
          int size = queue.size();
          while(size-- > 0) {
              int cur = queue.poll();
              int row = cur / cols;
              int col = cur % cols;
              for(int[] index : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
                  int x = row + index[0];
                  int y = col + index[1];
                  if(x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O') {
                      board[x][y] = 'A';
                      queue.offer(x*cols + y);
                  }
              }
          }
      }
  }
}
*/