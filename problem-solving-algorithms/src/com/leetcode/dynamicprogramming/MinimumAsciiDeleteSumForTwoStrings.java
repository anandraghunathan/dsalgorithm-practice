package com.leetcode.dynamicprogramming;

/**
 *  https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 *  Intuition:
 *      Its classic LCS - Longest Common Subsequence problem.
 *
 *  Time  : O(m * n)
 *  Space : O(m * n)
 */
public class MinimumAsciiDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] minSum = new int[m + 1][n + 1];
        /*
            When one of the input strings is empty, the answer is the SUM of the ASCII value of the current char at the
            index of s1. We can calculate this cumulatively using code like dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1)

            Similarly do it for the other string s2
         */
        for(int i = 1; i <= m; i++) {
            // fill up the 0th column
            minSum[i][0] = minSum[i - 1][0] + s1.charAt(i - 1);
        }

        for(int j = 1; j <= n; j++) {
            // fill up the diagonal from top 0 to bottom most cell
            minSum[0][j] = minSum[0][j - 1] + s2.charAt(j - 1);
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                /*
                    When s1[i] == s2[j], we have dp[i][j] = dp[i-1][j-1] as we can ignore these two characters cause we
                    have to find the mismatch characters and SUM their ASCII value
                 */
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // Found a similar character, assign the diagonal cell value
                    minSum[i][j] = minSum[i - 1][j - 1];
                } else {
                    // Min because we are to find the min ASCII sum of deleted characters
                    minSum[i][j] = Math.min(minSum[i - 1][j] + s1.charAt(i - 1),
                            minSum[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return minSum[m][n]; // return the right bottom most cell value which will be our result
    }

    public static void main(String[] args) {
        MinimumAsciiDeleteSumForTwoStrings obj = new MinimumAsciiDeleteSumForTwoStrings();
        System.out.println(obj.minimumDeleteSum("sea", "eat"));
    }
}
