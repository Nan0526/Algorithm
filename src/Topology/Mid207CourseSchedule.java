package Topology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
 * take course bi first if you want to take course ai.
For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
 */

//building inDegree 
//building graph using Map
//using BFS to expand(for with inDegree 0) - reducing 1 in it's next course inDegree


public class Mid207CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        
        //using bfs to expand
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                int cur = queue.poll();
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
                return false;
            }
        }
        return true;
    }
}
