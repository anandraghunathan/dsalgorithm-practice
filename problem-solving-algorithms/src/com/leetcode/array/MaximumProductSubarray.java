package com.leetcode.array;

/**
 * Created by Anand Raghunathan on 2019-07-15
 *
 * https://leetcode.com/problems/maximum-product-subarray/
 * Time  : O(n)
 * Space : O(1)
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;

        // To store the prev max value from multiplying contiguous elements of the array
        int maxPrev = nums[0];

        // To store the prev min value from multiplying contiguous elements of the array
        int minPrev = nums[0];

        /* To store the global max (for the entire array) of multiplying contiguous
        elements of the entire array */
        int maxProduct = nums[0];

        // Local max and min to store the max and min for the current iteration
        int max, min;

        // Start from the first index of the array as the 0th index is already taken care
        for(int i = 1; i < nums.length; i++) {
            /*
                Math.max with both maxPrev * nums[i] and minPrev * nums[i] is done to handle
                input cases like [-2, 3, -4], where the maxProduct is -2 * 3 * -4 = 24 and
                input cases like [-2, 1, -1], where the maxProduct is -2 * 1 * -1 = 2

                Similarly for min as well.

            */
            max = Math.max(Math.max(maxPrev * nums[i], minPrev * nums[i]), nums[i]);
            min = Math.min(Math.min(maxPrev * nums[i], minPrev * nums[i]), nums[i]);

            maxProduct = Math.max(maxProduct, max);

            // Assigning the prev max and min for the next iteration
            maxPrev = max;
            minPrev = min;
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4}));
    }
}
