package SlidingWindow;

import java.util.TreeSet;

//1 - keep low time & space complexity
//2 - keep max & min values --- using TreeSet/2 monotonic queue
//3 - keep the sliding window of max & min value difference under or equals to limit

//TreeSet - 使用规则 - 
class Mid1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
  public int longestSubarray(int[] nums, int limit) {
      //if using brute force - for - for - for - check every possible subarray - then check the max & min value - O(n^3)
      //or optimize - to for the whole nums - then a certain length of subarray - then maintain the certain max & min value - O(n^2)
      //using sliding window && TreeSet/TreeMap / 2 monotonic queue to maintain the max & min value - O(n)
      //since the contrains: - 1 <= nums.length <= 10^5 - can only use O(n) - since if O(n^2) - beyond 10^9 - max value?
      
      int slow = 0;
      int res = 1;
      TreeSet<Integer> set = new TreeSet<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
      set.add(0);
      
      for(int fast = 1; fast < nums.length; fast++) {
          set.add(fast);
          //System.out.println(nums[set.ceiling((Integer)2)] + " " + set.ceiling((Integer)2));
          //System.out.println(nums[set.floor((Integer)0)] + " " + set.floor((Integer)0));
          //floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null.
          //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
          //System.out.println(nums[set.first()] + " " + set.first());
          //Higher()方法用于返回此TreeSet中比指定元素(ele)高的最低元素
          //lower()方法用于返回此TreeSet中最大的元素，该元素比指定的元素(ele)低，如果存在则最大，否则返回null。
          while(nums[set.last()] - nums[set.first()] > limit) {
              set.remove(slow++);
          }
          res = Math.max(res, fast - slow + 1);
      }
      
      return res;
  }
}


/*
//2 monotonic queues
class Solution {
  public int longestSubarray(int[] nums, int limit) {
     
      int slow = 0;
      int res = 0;
      Deque<Integer> max = new LinkedList<>();
      Deque<Integer> min = new LinkedList<>();
      //for走过的都在max或者min了
      for(int fast = 0; fast < nums.length; fast++) {
          //while -- 保证万一来个比之前两个大的 - 则可以持续把两个都去掉
          
          while(!max.isEmpty() && nums[fast] > max.peekLast()) {
              max.pollLast();
          }
          while(!min.isEmpty() && nums[fast] < min.peekLast()) {
              min.pollLast();
          }
          
          max.offer(nums[fast]);
          min.offer(nums[fast]);
          
          while(max.peekFirst() - min.peekFirst() > limit) { //?
              if(max.peekFirst() == nums[slow]) {
                  max.pollFirst();
              }
              if(min.peekFirst() == nums[slow]) {
                  min.pollFirst();
              }
              slow++;
          }
          
          if(max.peekFirst() - min.peekFirst() <= limit) {
              res = Math.max(res, fast - slow + 1);
          }
      }
      return res;
  }
}
*/