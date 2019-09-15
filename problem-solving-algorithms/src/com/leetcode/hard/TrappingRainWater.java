package com.leetcode.hard;

/**
 *  https://leetcode.com/problems/trapping-rain-water/
 *
 */
public class TrappingRainWater {

    /**
        Brute-Force Algorithm

             For each element in the array, we find the maximum level of water it can trap after the rain, which is
             equal to the minimum of maximum height of bars on both the sides minus its own height.

        Algorithm:

             Initialize max = 0
             Iterate the array from left to right:
             a. Initialize maxLeft = 0 and maxRight = 0
             b. Iterate from the current element to the beginning of array, moving right to left:
             maxLeft = Max(maxLeft, height[j])
             c. Iterate from the current element to the end of array, moving left to right:
             maxRight = Max(maxRight, height[j])
             d. Add min(maxLeft, maxRight) - height[i] to the max

        Time  : O(n ^ 2), for each element in the array, we iterate the left and right parts.
        Space : O(1), constant space.
     */
    public static int trapBruteForce(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            int maxLeft = 0, maxRight = 0;
            for(int j = i; j >= 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }

            for(int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            max += Math.min(maxLeft, maxRight) - height[i];
        }
        return max;
    }

    /**
     *
     * REFER TO THE APPROACH 4 (UNDER SOLUTION) OF THIS PROBLEM
     *
     * Instead of computing the left and right parts separately, we may think of some way to do it in one iteration.
     * We can notice that as long as rightMax > leftMax (from element 0 to 6), the water trapped depends upon the leftMax
     * and similar is the case when leftMax > rightMax (from element 8 to 11).
     *
     * So, we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would
     * be dependant on height of bar in current direction (from left to right). As soon as we find the bar at
     * other end (right) is smaller, we start iterating in opposite direction (from right to left).
     * We must maintain leftMax and rightMax during the iteration, but now we can do it in one iteration using
     * 2 pointers, switching between the two.
     *
     * Time  : O(n). Single iteration of O(n)
     * Space : O(1). Only constant space required for left, right, leftMax and rightMax
     */

    public static int trap(int[] height) {
        int max = 0, left = 0, right = height.length - 1, leftMax = 0, rightMax = 0;
        while(left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if(leftMax < rightMax) {

                /* leftMax is smaller than rightMax, so the (leftMax - height[left])
                    water can be stored */
                max += leftMax - height[left];

                left++; // move to the next pointer from left
            } else {

                /* leftMax is greater than rightMax, so the (rightMax - height[right])
                    water can be stored */
                max += rightMax - height[right];

                right--; // move to the next pointer from right
            }
        }
        return max;
    }

    public static void main(String[] args) {
        //System.out.println(trapBruteForce(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
