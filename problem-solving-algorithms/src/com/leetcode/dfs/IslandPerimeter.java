package com.leetcode.dfs;

/**
 *
 *  https://leetcode.com/problems/island-perimeter/
 *
 *  Intuition:
 *      Only check right and down, because left and up would have been checked by the previous element's iteration.
 *      A neighbor subtracts a side from the perimeter. But since we only count right and down, we have to double count.
 *      thus -2 * neighbors.
 *
 *      We are checking bottom and right because we are iterating through the 2D array. At any '1' we would've
 *      already checked all the elements before that element(top or left elements). We are multiplying by 2 because
 *      we are removing the common edges that we are already considering as part of the 4 * islands.
 *
 *  Time  : O(N)
 *  Space : O(1)
 */
public class IslandPerimeter {

    /*
        {0,1,0,0},
        {1,1,1,0},
        {0,1,0,0},
        {1,1,0,0}
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    perimeter += 4; // Add 4 sides to constitute the square's 4 sides
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        perimeter -= 2; // We remove two sides cause we are moving only down and not up as well
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        perimeter -= 2; // We remove two sides cause we are moving only right and not left as well
                }
            }
        }
        return perimeter;
    }

    /** Alternate approach */
    public int islandPerimeter2(int[][] grid) {
        int land = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0 || grid[i - 1][j] == 0)
                        land++;
                    if(j == 0 || grid[i][j - 1] == 0)
                        land++;
                    if(i + 1 == grid.length || grid[i + 1][j] == 0)
                        land++;
                    if(j + 1 == grid[0].length || grid[i][j + 1] == 0)
                        land++;
                }
            }
        }
        return land;
    }

    public static void main(String[] args) {
        IslandPerimeter obj = new IslandPerimeter();
        System.out.println(obj.islandPerimeter(new int[][]
                                                          {
                                                            {0,1,0,0},
                                                            {1,1,1,0},
                                                            {0,1,0,0},
                                                            {1,1,0,0}
                                                          }
                                               ));
    }
}
