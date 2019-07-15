package com.leetcode.hard;

/**
 *
 */
public class TrappingRainWater {

    /**
     *
     * REFER TO THE APPROACH 4 (UNDER SOLUTION) OF THIS PROBLEM
     *
     * So, we can say that if there is a larger bar at one end (say right), we are assured that the water trapped would
     * be dependant on height of bar in current direction (from left to right). As soon as we find the bar at
     * other end (right) is smaller, we start iterating in opposite direction (from right to left).
     * We must maintain leftMax and rightMax during the iteration, but now we can do it in one iteration using
     * 2 pointers, switching between the two.
     *
     *
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
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
