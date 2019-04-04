package com.leetcode.dynamicprogramming;


/**
 * Bottom up DP solution
 * Runtime : O(S * n), where S is the amount, n is denomination count
 * Space : O(S)
 */
public class CoinChangeNumberOfCombinations {
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int coin : coins) {
            for(int i = 1; i < dp.length; i++) {
                if(coin <= i)
                    dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2, 5}, 5));
    }
}
