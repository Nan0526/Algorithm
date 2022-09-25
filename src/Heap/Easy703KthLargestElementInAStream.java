package Heap;

import java.util.PriorityQueue;

public class Easy703KthLargestElementInAStream {
	//point is - Kth largest - 第k个大的 - 就是从最大到排到这
	    int k;
	    PriorityQueue<Integer> minHeap;
	    public void KthLargest(int k, int[] nums) {
	        this.k = k;
	        minHeap = new PriorityQueue<>();
	        for(int n : nums) {
	            add(n);
	        }
	    }
	    
    public int add(int val) {
        if(minHeap.size() < k) {
            minHeap.offer(val);
        }else if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}


