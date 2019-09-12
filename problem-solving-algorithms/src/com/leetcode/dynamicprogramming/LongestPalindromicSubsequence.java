package com.leetcode.dynamicprogramming;

/**
 * Created by Anand Raghunathan on 2019-09-11
 *
 *
 */
public class LongestPalindromicSubsequence {
    /**
     *
     * Naive - Brute force approach.
     *
     * If the two ends of a string are the same, then they must be included in the longest palindrome subsequence.
     * Otherwise, both ends cannot be included in the longest palindrome subsequence.
     *
     * Time  : O(2 ^ n)
     * Space : O(N)
     */
    public int longestPalindromeSubseqBruteForce(String s) {
        return longestPalindromeRecurse(0, s.length() - 1, s);
    }

    public int longestPalindromeRecurse(int l, int r, String s) {
        if(l > r)
            return 0;

        if(l == r)
            return 1;

        if(s.charAt(l) == s.charAt(r)) {
            return 2 + longestPalindromeRecurse(l+1, r-1, s);
        } else {
            return Math.max(longestPalindromeRecurse(l+1, r, s), longestPalindromeRecurse(l, r-1, s));
        }
    }

    /**
     *
     * https://www.youtube.com/watch?v=_nCsPn7_OgI&t=57s
     *
     * https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
     *
     * Check this visualization:
     *      https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution/103142
     *
     *  Time  : O(n ^ 2)
     *  Space : O(n ^ 2)
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1; // Initialize the diagonal values of the table to 1
            for(int j = i + 1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    /*
                        2 comes from the two characters (left and right) matched and we pick the cell i+1, j-1
                        In other words, for subsequence bdb, b and b match, so we check the cell for d by doing
                        i + 1(0 + 1) and j - 1(2 - 1), and d's cell is 1, so in total 2 + 1 = 3
                     */
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    // If the front and back characters are not the same, the current cell of the table will get the
                    // value that's the max of value between the left and bottom of itself
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindromeSubseq("bbbab"));
    }
}
