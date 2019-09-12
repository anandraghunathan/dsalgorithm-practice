package com.leetcode.dynamicprogramming;

/**
 * Created by Anand Raghunathan on 2019-09-12
 *
 *  https://leetcode.com/problems/longest-common-subsequence/
 *
 *  https://leetcode.com/problems/longest-common-subsequence/discuss/348884/C%2B%2B-with-picture-O(nm)
 *
 *  Bottom-up DP utilizes a matrix m where we track LCS sizes for each combination of i and j.
 *
 *  If a[i] == b[j], LCS for i and j would be 1 plus LCS till the i-1 and j-1 indexes.
 *  Otherwise, we will take the largest LCS if we skip a charracter from one of the string
 *  (max(m[i - 1][j], m[i][j - 1]).
 *
 *  Time  : O(n ^ 2)
 *  Space : O(n ^ 2)
 *
 */
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        if(m == 0 || n == 0)
            return 0;

        // Not m + 1, n + 1 matrix length
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // Staring from 1 and checking the left and top cells. Check if those chars are same
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    // If the chars are the same, add + 1 to the diagonal cell
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
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        System.out.println(obj.longestCommonSubsequence("xabccde", "ace"));
    }
}
