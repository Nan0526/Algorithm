package HashTable;

import java.util.HashSet;
import java.util.Set;

/*
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 
Example 1:
Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
 */

//using hashSet - for deduplication
public class Mid36ValidSudoku {

public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0; i < 9; i += 3) {
            for(int j = 0; j < 9; j += 3) {
                if(!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        for(int i = 0; i < 9; i++) {
            if(!isValidRow(board, i) || !isValidCol(board, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            char c = board[row][i];
            if(c != '.' && !set.add(c)) { // set.add
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 9; i++) {
            char c = board[i][col];
            if(c != '.' && !set.add(c)) { // set.add
                return false;
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char c = board[row + i][col + j]; // 上边从0-3，下面加上row/col
                if(c != '.' && !set.add(c)) { // set.add
                    return false;
                }
            }
        }
        return true;
    }
}
    
    