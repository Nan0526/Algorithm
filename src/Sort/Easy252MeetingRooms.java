package Sort;

import java.util.Arrays;

/*
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: false
 */

public class Easy252MeetingRooms {

	public boolean canAttendMeetings(int[][] intervals) {
        //sort first
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        
        
        for(int i = 1; i < intervals.length; i++) {
            //System.out.println(intervals[i][0]);
            if(intervals[i][0] < intervals[i - 1][1]) { // i - 1
                return false;
            }
        }
        return true;
    }
}
