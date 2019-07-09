package com.leetcode.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int sell = 0;
        int prevSell = 0;
        // Start with the least buy value. To make sure we always buy at first step, we initialize buy = min_value;
        int buy = Integer.MIN_VALUE;
        int prevBuy;

        // We have to rest before we buy. And we have to buy before we sell
        for(int currentPrice : prices) {
            prevBuy = buy; /** technically, prevBuy = buy(i - 1) */

            // buy[i] = max(sell[i-2]-price, buy[i-1])
            buy = Math.max(prevSell - currentPrice, prevBuy); /** prevSell = sell(i-2) */

            /*
                (sell[i - 2]) -> prev_sell = sell means when sell is day i, prev_sell is day (i-1).
                And the code does this assignment after buy = Math.max(prev_sell - price, prev_buy),
                then when day (i+1), the prev_sell use for buy calculation is still day (i-1).
                Therefore, rest after sell is taken care.
             */
            prevSell = sell; /** prevSell = sell(i-1) */

            // sell[i] = max(buy[i-1]+price, sell[i-1])
            sell = Math.max(prevBuy + currentPrice, prevSell);
        }
        return sell;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,2,1,0,2}));
    }
}
