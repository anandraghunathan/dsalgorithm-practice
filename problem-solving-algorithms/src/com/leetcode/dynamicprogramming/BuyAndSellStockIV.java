package com.leetcode.dynamicprogramming;

public class BuyAndSellStockIV {
    /**
     The solution includes maxProfitII https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     to avoid Memory Limit exceeded/TLE errors
     */

    /**
     *
     * https://www.youtube.com/watch?v=oDhu5uGq_ic
     *
     * This is faster method which does optimization on slower method
     * Time complexity here is O(K * number of days)
     *
     * Formula is
     * T[i][j] = max(T[i][j-1], prices[j] + maxDiff)
     * maxDiff = max(maxDiff, T[i-1][j] - prices[j])
     */

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;

        if(k >= n/2)
            return maxProfitII(prices);

        // Empty check
        if(k == 0 || n == 0)
            return 0;

        /*
            Declaring an int 2D array with,
            1. Given transaction number + 1 as rows
            2. Given days as columns
        */
        int[][] T = new int[k + 1][n];
        for(int i = 1; i < T.length; i++) {
            int maxDiff = -prices[0];
            for(int j = 1; j < T[0].length; j++) {
                T[i][j] = Math.max(T[i][j - 1], prices[j] + maxDiff);
                maxDiff = Math.max(maxDiff, T[i - 1][j] - prices[j]);
            }
        }
        return T[k][n - 1];
    }

    /**
     This is included as per https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     to avoid Memory Limit exceeded/TLE errors
     */
    private static int maxProfitII(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for(int i = 1; i < n; i++) {
            if(prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
