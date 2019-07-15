package com.leetcode.array;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Time  : O(n). One pass
 * Space : O(1). No extra space used.
 *
 * Similar Hard Problem -  https://leetcode.com/problems/trapping-rain-water/
 *
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        // Start two pointers. One from left, the other from right
        int maxArea = 0, left = 0, right = height.length - 1;
        while(left < right) {
            /**
             * We need to consider the area between two lines (on either side) of larger lengths.
             * Therefore, the max area could be impacted by the line with shorter length, despite
             * the other line being longer. So, moving out of shorter line's pointer inwards to a longer
             * line might offset and maximize the area, despite the reduction in the width.
             */
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            /* If the height value in the array on the left is smaller, we move the left pointer by 1,
             Otherwise, we move the right pointer by 1. */
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
