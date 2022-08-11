package BinarySearch;

/*
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

public class Hard4MedianOfTwoSortedArrays {

	//思路： 变成一个可以移动的两层挡板
    //12｜489 ---短的当上边 - binary search移动的少 - 
    //235｜78 --- 靠挡板的四个数对比 - 左上和右下比 && 同时右上和左下比
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //corner
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);
        
        int left = 0;
        int right = len1;
        while(left <= right) {
            int x = left + (right - left) / 2;
            int y = (len + 1)/2 - x;
            
            /*
            int xLeft = nums1[x - 1];
            int xRight = nums1[x];
            int yLeft = nums2[x - 1];
            int yRight = nums2[x];
            */
            
            int xLeft = x == 0 ? Integer.MIN_VALUE : nums1[x - 1];
            int xRight = x == len1 ? Integer.MAX_VALUE : nums1[x];
            int yLeft = y == 0 ? Integer.MIN_VALUE : nums2[y - 1];
            int yRight = y == len2 ? Integer.MAX_VALUE : nums2[y];
            
            //System.out.println(xLeft + " " + xRight + " " + yLeft + " " + yRight + " " + x + " " + y);
            
            if(xLeft <= yRight && yLeft <= xRight) {
                if(len % 2 == 0){
                    //System.out.println(len);
                    //System.out.println(Math.min(xRight, yRight)  + " " + Math.max(xLeft, yLeft));
                    //最后问题在于 - 应该先double再除2 -- double一个or双个都OK
                    return (double)((Math.min(xRight, yRight) + Math.max(xLeft, yLeft))) / 2;
                } else {
                    return (double)Math.max(xLeft, yLeft);
                }
            }else if(xRight > yLeft){
                right = x - 1;
            }else {
                left = x + 1;
            }
            
            //System.out.println(xLeft + " " + xRight + " " + yLeft + " " + yRight + " " + x + " " + y);
        }
        
        return -1;
    }
}