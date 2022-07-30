package Sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1
 */

public class Mid253MeetingRoomsII {

public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        //priorityqueue for sorting the ending time
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //smallest comes out first
        minHeap.offer(intervals[0][1]);
        
        for(int i = 1; i < intervals.length; i++) {
            System.out.println(minHeap.peek());
            if(minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();    
            }
            minHeap.offer(intervals[i][1]);
        }
        
        return minHeap.size();
    }
}
