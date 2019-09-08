package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = Integer.MAX_VALUE;
        /*
            1. Iterate through the array.
            2. Get the buyPrice first
            3. Calculate the maxProfit by getting the difference between the
                current price and the buyPrice calculated in the 2nd step
        */
        for(int i = 0; i < prices.length; i++) {
            buyPrice = Math.min(buyPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
