package com.leetcode.tree.bst;

/**
 * Created by Anand Raghunathan on 2019-07-30
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Time: O(n ^ 2)
 * Space: O(n)
 */
public class UniqueBinarySearchTree {
    /**
     *
     * https://www.youtube.com/watch?v=GgP75HAvrlY
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }
}
