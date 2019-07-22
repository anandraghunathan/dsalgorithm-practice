package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * Time:   O(mn)
 * Space : O(n)
 */
public class MaximumSquare {
    /**
     *
     * Scan the 2D matrix row by row by maintaining a dp array to update the largest square, based on the value of the
     * matrix at the corresponding index (i, j). Only consider if the value at the index is '1'
     */
    public static int maximalSquare(char[][] matrix) {
        // Handle empty first
        if(matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, max = 0;

        // A 2D array that we will populate based on the input matrix filled with 0's and 1's
        int[][] dp = new int[m + 1][n + 1];

        // Iterate through the rows and columns of the input matrix starting to with 1 to compare the previous index
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // See if the previous index to the current i and j - (i - 1) of (j - 1) index element is '1'
                if(matrix[i - 1][j - 1] == '1') {
                    /**
                     Inspect,
                     1. Current index's left index,
                     2. Current index's left top index,
                     3. Current index's top index.
                     If all 3 are 1, which means we found a square. So a min of these 3 will yield a 1, +1 gives 2.
                     */
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;

                    // If the current index of the dp array is bigger than the previous result, push the current value as the max
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]
                {
                        {'1','0','1','1'},
                        {'1','1','1','1'},
                        {'1','0','0','1'},
                        {'1','0','1','1'}

                };
        System.out.println(maximalSquare(matrix));
    }
}
