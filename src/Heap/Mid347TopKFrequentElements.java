package Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer 
 * in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]
 * 
 */

public class Mid347TopKFrequentElements {

	public int[] topKFrequent(int[] nums, int k) {
        //using hashmap to store number frequence and get the top k elements
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        
        /* 
        //or这样写
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));
        */
        
        for(int n : map.keySet()) {
            heap.offer(n);
        }
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        
        return res;
    }
}
