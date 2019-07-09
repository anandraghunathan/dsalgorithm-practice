package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/perfect-squares/
 * Time: O(n * sqrt(n))
 * Space: O(n)
 */
public class PerfectSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        //Arrays.fill(dp, Integer.MAX_VALUE);
        //dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            // For ex: (13 - 1 * 1 >= 0), (13 - 2 * 2 >=0)
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
}
