package Trie;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/*
 * Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example 1:
Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
 */

public class Hard212WordSearchII {
	Set<String> set = new HashSet<>();
    TrieNode root = new TrieNode(' ');
    public List<String> findWords(char[][] board, String[] words) {
        //using trie to build TrieTree
        //search the words in the board with TrieTree - searcing in the matrix - then see whether this character is in the TrieTree
        buildTrieTree(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        TrieNode cur = root;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(cur.children[board[i][j] - 'a'] != null) {
                    visited[i][j] = true;
                    //cur = root; // 因为每个都是只要进去第一个就可以 - 第一个就是cur.children - 所以不需要每次都cur=root - 在上边写就行
                    dfs(board, visited, i, j, cur.children[board[i][j] - 'a']);// 这边传进去的需要是第一个字母对应的TrieNode
                    visited[i][j] = false;
                }
                
            }
        }
        System.out.println(set);
        return new LinkedList<>(set);
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode cur) {
        if(cur.s != null) {
            //System.out.println(cur.s);
            set.add(cur.s);
        }
        
        //System.out.println(cur.s);
        for(int[] dir : new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y] && cur.children[board[x][y] - 'a'] != null) {
                visited[x][y] = true;
                dfs(board, visited, x, y, cur.children[board[x][y] - 'a']);
                visited[x][y] = false;
            }
        }
    }
    
    private void buildTrieTree(String[] words) {
        //TrieNode cur = root;
        for(String word : words) {
            TrieNode cur = root;//每次都要这样 - 需要注意地方 - 每个单词创建都需要把cur换到root
            for(char c : word.toCharArray()) {
                System.out.println(c);
                if(cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode(c);
                }
                cur = cur.children[c - 'a'];
            }
            
            cur.s = word;
            System.out.println(cur.s);
        }
    }
    class TrieNode{
        char val;
        TrieNode[] children;
        String s;
        
        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[26];
            s = null;//default成null
        }
    }
}

