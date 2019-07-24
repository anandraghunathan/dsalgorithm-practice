package com.leetcode.array;

/**
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 *
 * Time  : O(N ^ 2)
 * Space : O(N)
 */
public class MaxIncreaseToKeepCitySkyline {
    /**
     * Each row has a max and each column has a max. You need to increase the values in each by the same amount
     * while not creating a new max value for that row or column.
     */
    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] colMax = new int[n];

        // The first loop of grid calculate the maximum for every row and every col.
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }

        int maxHeightSum = 0;

         // The second loop calculate the maximum increasing height for every building.
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                /**
                   The maximum increasing height for a building at (i, j) is min(row[i], col[j]) - grid[i][j],
                   If it were larger, say grid[r][c] > max(row[i]), then the part of the skyline
                   rowMax = [..., max(row[i]), ...] would change, thereby increasing (modifying) the skyline.
                   Therefore, we do a min of rowMax[i] and colMax[j] that will not create a new max value for that row or column,
                   this will increase the height of each building without affecting the skylines
                 */


                /**
                    To find the maximum increasing height for each building without affecting the height of the skyline,
                    we have to do a min(rowMax, colMax) for that particular index (building) and deduct the current grid[i][j].
                    By doing min, we avoid increasing the skyline, but still increasing the height of the buildings
                */
                maxHeightSum += Math.min(rowMax[i], colMax[j]) - grid[i][j];

        return maxHeightSum;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                                    {
                                            {3, 0, 8, 4},
                                            {2, 4, 5, 7},
                                            {9, 2, 6, 3},
                                            {0, 3, 1, 0}
                                    };

        System.out.println(maxIncreaseKeepingSkyline(grid));
    }
}
