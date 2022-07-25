package Stack;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
 */


public class Mid739DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
        //maintain a decending stack
        //so we can always get the higher temp than the stack's, then record the date
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        //stack.push(1);必须用下面的isEmpty判断非空 - 因为不一定T[1] - 是大是小 - 说不定就出去了 -还是空
        
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.poll();
                res[index] = i - index;
            }
            stack.push(i);
        }
        
        return res;
    }
}
