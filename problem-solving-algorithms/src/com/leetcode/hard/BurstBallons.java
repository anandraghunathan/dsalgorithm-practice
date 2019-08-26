package com.leetcode.hard;

public class BurstBallons {
    public int maxCoins(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int start = 0; start <= nums.length - len; start++) {
                int end = start + len - 1;
                for (int i = start; i <= end; i++) {
                    /*
                        leftValue/rightValue is initially 1. If there is an element on
                        left/right of i then left/right value will take that value.
                     */
                    int leftValue = 1;
                    int rightValue = 1;
                    if (start != 0) {
                        leftValue = nums[start - 1];
                    }
                    if (end != nums.length - 1) {
                        rightValue = nums[end + 1];
                    }
                    /*
                        "before" is initially 0. If i is "start" then "before" will
                        stay 0 otherwise it gets value dp[start][i - 1]
                        "after" similarly is 0 initially. If i is "end" then "after" will
                        stay 0 otherwise it will get value dp[i + 1][end]
                     */
                    int before = 0;
                    int after = 0;
                    if (start != i) {
                        before = dp[start][i - 1];
                    }
                    if (end != i) {
                        after = dp[i + 1][end];
                    }

                    int coins = 0;
                    coins += leftValue * nums[i] * rightValue;
                    coins += before + after + dp[start][end];
                    dp[start][end] = Math.max(dp[start][end], coins);
                }
            }
        }
        return dp[0][nums.length - 1];
    }

    public static void main(String[] args) {
        BurstBallons obj = new BurstBallons();
        System.out.println(obj.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
