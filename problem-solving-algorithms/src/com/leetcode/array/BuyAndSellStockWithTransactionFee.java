package com.leetcode.array;

public class BuyAndSellStockWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {

        // Don't hold any stock, so cash is NOT used
        int cash = 0;

        // Hold a stock ('-' because we bought the stock, so cash reduces by the amount at index 0
        int hold = -prices[0];

        for(int i = 1; i < prices.length; i++) {

            // Cash increases when we end up selling the stock, but transaction fee has to be deducted
            cash = Math.max(cash, hold + prices[i] - fee);

            // Hold decreases the cash by the amount at the index
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        // TODO
    }
}
