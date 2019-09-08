package com.leetcode.dynamicprogramming;

public class MinimumPathSum {
    /**
     *
     *  https://leetcode.com/problems/minimum-path-sum/
     *
     *  Intuition:
     *      This is a typical DP problem. Suppose the minimum path sum of arriving at point (i, j) is S[i][j],
     *      then the state equation is S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j].
     *
     *  Algorithm:
     *      Well, some boundary conditions need to be handled. The boundary conditions happen on the
     *      top most row (S[i - 1][j] does not exist) and the leftmost column (S[i][j - 1] does not exist).
     *      Suppose grid is like [1, 1, 1, 1], then the minimum sum to arrive at each point is simply an accumulation of
     *      previous points and the result is [1, 2, 3, 4].
     *
     *      As it can be seen, each time when we update sum[i][j], we only need sum[i - 1][j] (above row, current column)
     *      and sum[i][j - 1] (same row, left column). So we need not maintain the full m*n matrix. Maintaining two
     *      columns is enough and now we have the following code.
     *
     *  Time  : O(M * N), we build the grid table by summing up the rows and columns
     *  Space : O(1), we use constant space as we modify the existing grid
     *
     */
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(i == 0 && j != 0)
                    grid[i][j] += grid[i][j - 1];
                else if (i != 0 && j == 0)
                    grid[i][j] += grid[i - 1][j];
                else if (i != 0 && j != 0)
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }
}
