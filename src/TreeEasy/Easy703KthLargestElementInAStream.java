package TreeEasy;

import java.util.PriorityQueue;

/*
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
Implement KthLargest class:
KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.
int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.
 
Example 1:
Input
["KthLargest", "add", "add", "add", "add", "add"]
[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
Output
[null, 4, 5, 5, 8, 8]
 */

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