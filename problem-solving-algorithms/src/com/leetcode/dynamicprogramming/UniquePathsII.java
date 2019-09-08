package com.leetcode.dynamicprogramming;

public class UniquePathsII {
    /**
     *  https://leetcode.com/problems/unique-paths-ii
     *
     *  Refer to the solutions tab
     *
     *  Intuition:
     *      The robot can only move either down or right. Hence any cell in the first row can only be reached from the
     *      cell left to it. For any other cell in the grid, we can reach it either from the cell to left of it or
     *      the cell above it.
     *
     *      If any cell has an obstacle, we won't let that cell contribute to any path.
     *
     *      We will be iterating the array from left-to-right and top-to-bottom. Thus, before reaching any cell we would
     *      have the number of ways of reaching the predecessor cells. This is what makes it a Dynamic Programming
     *      problem. We will be using the obstacleGrid array as the DP array thus not utilizing any additional space.
     *
     *      Note: As per the question, cell with an obstacle has a value 1. We would use this value to make sure if a
     *      cell needs to be included in the path or not. After that we can use the same cell to store the number of
     *      ways to reach that cell.
     *
     *  Time  : O(m * n). The rectangular grid given to us is of size M × N and we process each cell just once.
     *  Space : O(1). We are utilizing the same input array as the DP array, so no extra space.
     *
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        /*
            If the starting cell has an obstacle, then simply return as there would
            be no paths to the destination.
        */
        if(obstacleGrid[0][0] == 1)
            return 0;

        // Number of ways of reaching the starting cell = 1.
        obstacleGrid[0][0] = 1;

        // Filling the values for the first row
        for(int j = 1; j < n; j++) {
            obstacleGrid[0][j] = (obstacleGrid[0][j] == 0 && obstacleGrid[0][j - 1] == 1) ? 1 : 0;
        }

        // Filling the values for the first column
        for(int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i -1][0] == 1) ? 1 : 0;
        }
        /*
            Starting from cell(1, 1) fill up the values
            Number of ways of reaching cell[i][j] = cell[i - 1][j] + cell[i][j - 1]
            i.e. From above and left.
        */
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        // Return value stored in rightmost-bottommost cell. That is the result.
        return obstacleGrid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII obj = new UniquePathsII();
        System.out.println(obj.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}
