package Sort;

import java.util.ArrayList;
import java.util.List;

/*
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of 
 * the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that 
 * represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any 
overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.

Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
 */

public class Mid57InsertInterval {

public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> list = new ArrayList<>();
        
        int i = 0;
        int n = intervals.length;
        
        //before
        while(i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }
        
        //overlap
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        list.add(newInterval);
        
        //after
        while(i < n) {
            list.add(intervals[i++]);
        }
        
        int[][] res = new int[list.size()][2];
        for(int j = 0; j < res.length; j++) {
            res[j] = list.get(j);
        }
        
        return res;
    }
}
