package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the 
 * non-overlapping intervals that cover all the intervals in the input.

Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */

public class Mid56MergeIntervals {

	public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            if(list.get(list.size() - 1)[1] >= intervals[i][0]) {//>=
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
            }else {
                list.add(intervals[i]);
            }
        }
        
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
