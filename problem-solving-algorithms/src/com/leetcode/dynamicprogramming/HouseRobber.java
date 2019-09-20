package com.leetcode.dynamicprogramming;

import java.util.Arrays;

public class HouseRobber {
    /** Top down memoized - Recursive */
    static int[] memo;
    public static int robR(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return robR(nums, nums.length - 1);
    }

    /** Recursive method */
    private static int robR(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }
        int result = Math.max(robR(nums, i - 2) + nums[i], robR(nums, i - 1));
        memo[i] = result;
        return result;
    }

    /** Bottom up - Iterative */
    public static int robI(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }

    /** Bottom up - With 2 pointers */
    public static int rob(int[] nums) {
        int preRob = 0, preNotRob = 0;
        for(int i = 0; i < nums.length; i++) {
            int rob = preRob, notRob = preNotRob;
            preRob = notRob + nums[i];
            preNotRob = Math.max(notRob, rob);
        }
        return Math.max(preNotRob, preRob);
    }


    public static void main(String[] args) {
        //System.out.println(robR(new int[]{2,7,9,3,1}));
        System.out.println(robI(new int[]{2,7,9,3,1}));
    }
}
