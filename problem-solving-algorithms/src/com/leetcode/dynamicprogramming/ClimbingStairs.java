package com.leetcode.dynamicprogramming;

public class ClimbingStairs {
    /**
     * DP bottom up iterative
     *
     * Time complexity : O(n). Single loop upto n.
     *
     * Space complexity : O(n). dp array of size n is used.
     *
     */
    public static int climbStairsI(int n) {
        if(n <= 0)
            return 0;

        if(n == 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Fibonacci number approach
     *
     * Time complexity : O(n). Single loop upto n is required to calculate nth fibonacci number.
     *
     * Space complexity : O(1). Constant space is used.
     */
    public static int climbStairsF1(int n) {
        if(n <= 0)
            return 0;

        if(n == 1)
            return 1;

        int first = 1;
        int second = 2;

        for(int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        //System.out.println(climbStairsI(2));
        System.out.println(climbStairsF1(1));
    }
}
