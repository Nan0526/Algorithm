package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words 
 * beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences 
from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of 
the words [beginWord, s1, s2, ..., sk].

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
 */

//这个time limit exceeded了 - 但是思路应该是对的
//先build graph建图 - 再用dfs backtracking弄到所有的list
public class Hard126WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        startSet.add(beginWord);
        bfs(startSet, endWord, map, dict);
        
        System.out.println(map);
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, endWord, beginWord, map);
        
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, String endWord, String word, Map<String, List<String>> map) {
        if(word.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(map.get(word) == null) return;
        
        for(String next : map.get(word)) {
            list.add(next);
            dfs(res, list, endWord, next, map);
            list.remove(list.size() - 1);
        }
    }
    
    private void bfs(Set<String> startSet, String endWord, Map<String, List<String>> map, Set<String> dict) {
        if(startSet.size() == 0) {
            return;
        }
        
        Set<String> tmp = new HashSet<>();
        boolean finish = false;
        dict.removeAll(startSet);
        
        for(String s : startSet) {
            char[] chs = s.toCharArray();
            for(int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String word = new String(chs);
                    
                    if(dict.contains(word)) {
                        if(endWord.equals(word)) {
                            finish = true;
                        }else {
                            tmp.add(word);
                        }
                        
                        if(map.get(s) == null) {
                            map.put(s, new ArrayList<>());
                        }
                        
                        map.get(s).add(word);
                    }
                }
                
                chs[i] = old;
            }
        }
        
        //相当于bfs
        if(!finish) {
            bfs(tmp, endWord, map, dict);
        }
    }
    
}

/*
//reverse startSet & endSet - since endSet如果比startSet的小 - 则遍历起来更方便简单 - 
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        List<List<String>> res = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);
        if(!dict.contains(endWord)) return res;
        
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        
        bfs(startSet, endSet, map, dict, false);
        
        //System.out.println(map);
        
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, endWord, beginWord, map);
        
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, String endWord, String word, Map<String, List<String>> map) {
        if(word.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(map.get(word) == null) return;
        
        for(String next : map.get(word)) {
            list.add(next);
            dfs(res, list, endWord, next, map);
            list.remove(list.size() - 1);
        }
    }
    
    private void bfs(Set<String> startSet, Set<String> endSet, Map<String, List<String>> map, Set<String> dict, boolean reverse) {
        if(startSet.size() == 0) {
            return;
        }
        if(startSet.size() > endSet.size()) {
            bfs(endSet, startSet, map, dict, !reverse);
            return;
        }
        Set<String> tmp = new HashSet<>();
        boolean finish = false;
        dict.removeAll(startSet);
        
        for(String s : startSet) {
            char[] chs = s.toCharArray();
            for(int i = 0; i < chs.length; i++) {
                char old = chs[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    chs[i] = c;
                    String word = new String(chs);
                    
                    if(dict.contains(word)) {
                        if(endSet.contains(word)) {
                            finish = true;
                        }else {
                            tmp.add(word);
                        }
                        
                        String key = reverse ? word : s;
                        String val = reverse ? s : word;
                        
                        if(map.get(key) == null) {
                            map.put(key, new ArrayList<>());
                        }
                        
                        map.get(key).add(val);
                    }
                }
                
                chs[i] = old;
            }
        }
        
        //相当于bfs
        if(!finish) {
            bfs(tmp, endSet, map, dict, reverse);
        }
    }
    
}
*/