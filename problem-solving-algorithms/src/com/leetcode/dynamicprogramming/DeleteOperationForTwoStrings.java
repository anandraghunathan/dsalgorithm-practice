package com.leetcode.dynamicprogramming;

/**
     Created by Anand Raghunathan on 2019-09-13

     https://leetcode.com/problems/delete-operation-for-two-strings

     https://www.youtube.com/watch?v=NnD96abizww&t=3s

     Intuition:
            Similar to the logic used in Longest Common Subsequence

            If a[i] == b[j], LCS for i and j would be 1 plus LCS till the i-1 and j-1 indexes (top diagonal. Otherwise,
            we will take the largest LCS if we skip a character from one of the string (max(m[i - 1][j], m[i][j - 1]).

            Finally, to make them identical, just find the longest common subsequence. The rest of the characters have to be
            deleted from both the strings, which does not belong to longest common subsequence, so we deduct subLen we
            found out from both word1 and word2 lengths

     Time  : O(n ^ 2), We need to fill in the dp array of size m x n. Here, m and n refer
             to the lengths of s1 and s2.
     Space : O(n ^ 2), dp array of size m x n is used.
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // If the chars are the same, add + 1 to the top diagonal cell
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    /*
                        Chars not same, find the max between top and left cells and assign
                        it to the current cell
                    */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        /*
            Deduct subLen we found out from both word1 and word2 lengths to find the number of
            deletes we need to make word1 and word2 the same
        */
        int subLen = dp[m][n];
        return (m - subLen) + (n - subLen);
    }
}
