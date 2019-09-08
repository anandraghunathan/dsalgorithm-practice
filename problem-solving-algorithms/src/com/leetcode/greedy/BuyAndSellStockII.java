package com.leetcode.greedy;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        // Greedy approach. Compare the current number to the previous one.
        // Add the profit only if the current is greater than previous
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,3,4,5}));
    }
}
