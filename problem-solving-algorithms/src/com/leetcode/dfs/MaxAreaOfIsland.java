package com.leetcode.dfs;

/**
 * Created by Anand Raghunathan on 2019-09-18
 *
 * https://leetcode.com/problems/max-area-of-island/
 *
 * Intuition:
 *      Perform DFS. The idea is to count the area of each island using dfs. During the dfs, we set the value of each
 *      point in the island to 0.
 *
 * Time  : O(MN), where M and N are number of rows and cols of the 2D matrix. Basically its a linear complexity
 * Space : O(1), no extra space used
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxCount = 0;
        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1)
                    // pass the grid to the dfs method with the current row and col
                    maxCount = Math.max(maxCount, maxArea(grid, r, c));
            }
        }
        return maxCount;
    }

    /*
        DFS. Check the boundary conditions and negative scenario for the cell being 0 first, then explore horizontal and
        vertical cells as asked in the given problem statement
    */
    public int maxArea(int[][] grid, int r, int c) {
        // Handle the negative conditions for index out of bounds and grid cell value not 1. Return 0
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0)
            return 0;

        /*
            Make the current cell (island) as 0 since this will added to our maxArea computation, and should not be
            considered again for future maxArea calculation
        */
        grid[r][c] = 0;
        return (1 + maxArea(grid, r + 1, c) + maxArea(grid, r, c + 1) + maxArea(grid, r - 1, c) + maxArea(grid, r, c - 1));
    }
}
