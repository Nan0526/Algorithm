package DFS;

/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

 */

public class Mid79WordSearch {

	public boolean exist(char[][] board, String word) {
        //iterate each character - 
        //then expand from each letter
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if(dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }//重点
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int i, int j, int index) {
        if(index == word.length() - 1) {
            return true;
        }
        
        for(int[] dir: new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && board[x][y] == word.charAt(index + 1)) {
                visited[x][y] = true;
                if(dfs(board, visited, word, x, y, index + 1)){
                    return true;
                }else {
                    visited[x][y] = false;
                }
            }
        }
        return false;
    }
}
