package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
 */


//bfs
class Hard127WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> set = new HashSet<>(wordList);//for deduplication
      //using bfs
      Queue<String> queue = new LinkedList<>();
      queue.offer(beginWord);
      
      int level = 0;
      while(!queue.isEmpty()) {
          int size = queue.size();
          level++;
          //System.out.println(level);
          while(size-- > 0) {
              String cur = queue.poll();
              //System.out.println(cur);
              //System.out.println(level);
              
              if(cur.equals(endWord)) { //两个string比较用.equals
                  return level;
              }
              char[] curArr = cur.toCharArray();
              for(int i = 0; i < curArr.length; i++) {
                  char temp = curArr[i];//等下换回去
                  for(char c = 'a';  c <= 'z'; c++) {
                      curArr[i] = c;
                      String s = new String(curArr);
                      //System.out.println(s);
                      if(set.contains(s)) {
                          queue.offer(s);
                          set.remove(s);
                      }
                  }
                  curArr[i] = temp;
              }
          }
      }
      
      return 0;
  }
}

/*
//dfs不行 - no - 会stackOverFlow - 因为每个word都是一层stack - 但bfs用queue就只是都用queue占用一样空间
class Solution {
  int level = 0;
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> set = new HashSet<>(wordList);//for deduplication
      //using dfs
      dfs(beginWord, endWord, wordList, set);
      return level;
  }
      
      
  private void dfs(String curWord, String endWord, List<String> wordList, Set<String> set) {
      if(curWord.equals(endWord)) { //两个string比较用.equals
          level++;
          return;
      }
      
      char[] curArr = curWord.toCharArray();
      for(int i = 0; i < curArr.length; i++) {
          char temp = curArr[i];//等下换回去
          for(char c = 'a';  c <= 'z'; c++) {
              curArr[i] = c;
              String s = new String(curArr);
              //System.out.println(s);
              if(set.contains(s)) {
                  dfs(s, endWord, wordList, set); //？还有点啥问题？
              }
          }
          curArr[i] = temp;
      }
      
  }
}
*/
