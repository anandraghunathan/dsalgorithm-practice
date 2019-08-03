package com.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * Time: O(N)
 * Space: O(N)
 */
public class SpiralMatrix {
    /**
     * Traverse the elements of the 2D array in a spiral form,
     *      1. top left to top right (till last index)
     *      2. one down (up + 1) from top right till one up (down - 1) from bottom
     *      3. bottom right till bottom left
     *      4. One up (down - 1) from bottom till one down (up + 1) to top
     *
     *      Then increment left and up, and decrement right and down. To traverse for the next iteration
     *
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>();

        if(matrix == null || matrix.length == 0)
            return res;

        int n = matrix.length, m = matrix[0].length;

        int up = 0, down = n - 1;
        int left = 0, right = m - 1;

        /**
         * We check the "res.size() < n * m" to ensure that the we don't re-add the same number already
         * added to the linked list during our traversal
         */
        while(res.size() < n * m) {
            for(int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);

            for(int i = up + 1; i <= down - 1 && res.size() < n * m; i++)
                res.add(matrix[i][right]);

            for(int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);

            for(int i = down - 1; i >= up + 1 && res.size() < n * m; i--)
                res.add(matrix[i][left]);

            left++; up++; right--; down--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        for(int num : spiralOrder(matrix)) {
            System.out.print(num + ", ");
        }
    }
}
