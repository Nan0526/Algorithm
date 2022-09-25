package Heap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given an array of strings words and an integer k, return the k most frequent strings.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

Example 1:
Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
 */

public class Mid692TopKFrequentWords {

	public List<String> topKFrequent(String[] words, int k) {
        //using hashmap to store frequency and get the top k strings
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])) {
                map.put(words[i], map.get(words[i]) + 1);
            }else {
                map.put(words[i], 1);
            }
        }
        
        //不能用a.charAt(0) - b.charAt(0) --- 要用a.compareTo(b) - 能把后边位数也比了
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        /* 
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2){
                if(m1.getValue().equals(m2.getValue())){
                    return m2.getKey().compareTo(m1.getKey());
                }
                return m1.getValue() - m2.getValue();
            }
        });
        */
        
        for(String n : map.keySet()) {
            heap.offer(n);
        }
        
        List<String> res = new LinkedList<>();
        for(int i = 0; i < k; i++) {
            res.add(heap.poll());
        }
        
        return res;
    }
}
