package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/house-robber-ii/
 *
 * Time  : O(N), we traverse through all the elements of the array
 * Space : O(1), we use only constant space
 */
public class HouseRobberII {
    /**
     *
     * Suppose there are n houses, since house 0 and n - 1 are now neighbors, we cannot rob them together and thus the
     * solution is now the maximum of
     *
     * Rob houses 0 to n - 2;
     * Rob houses 1 to n - 1.
     *
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        /*
         * See the max of either,
         * Rob houses 0 to n - 2 OR Rob houses 1 to n - 1 because we can't rob the first & last,
         * Also we can't rob two adjacent houses.
         */
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int lo, int hi) {
        int preRob = 0, preNotRob = 0;
        for (int i = lo; i <= hi; i++) {
            // preRob will be the previously robbed money from the previous index, similarly for preNotRob
            int rob = preRob, notRob = preNotRob;

            // preRob will be a sum of currently notRobbed money and current money at the index
            preRob = notRob + nums[i];

            // preNotRob will be the max of the notRob and rob
            preNotRob = Math.max(notRob, rob);
        }
        return Math.max(preRob, preNotRob); // return the max of preRobbed money and preNotRobbed money finally
    }

    public static void main(String[] args) {
        HouseRobberII obj = new HouseRobberII();
        System.out.println(obj.rob(new int[]{1,2,3,1}));
    }
}
