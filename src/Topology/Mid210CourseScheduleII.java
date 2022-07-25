package Topology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 */

public class Mid210CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        //
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        //build graph
        for(int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }
        
        //fill graph
        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        //start from inDegree 0
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> resList = new LinkedList<>();
        //using bfs to expand
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            while(size-- > 0) {
                int cur = queue.poll();
                resList.add(cur); // 这些最后都能弄完 - so ok的
                List<Integer> list = map.get(cur);
                for(int i = 0; i < list.size(); i++) {
                    inDegree[list.get(i)]--;
                    if(inDegree[list.get(i)] == 0) {
                        queue.offer(list.get(i));
                    }
                }
            }
        }
        
        //check whether all courses are finished
        for(int i = 0; i < inDegree.length; i++) {
            if(inDegree[i] != 0) {
                return new int[0];
            }
        }
        
        int[] resArr = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++) {
            resArr[i] = resList.get(i);
        }
        return resArr;
    }
}
