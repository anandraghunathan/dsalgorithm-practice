package com.leetcode.binarysearch;

/**
 * Created by Anand Raghunathan on 2019-07-15
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii
 *
 * Time: O(m + n), where m is the number of rows and n is the number of columns
 * Space: O(1)
 */
public class Search2DMatrixII {
    /*
        We start search the matrix from top right corner, initialize the current position to top
        right corner, if the target is greater than the value in current position, then the target
        can not be in entire row of current position because the row is sorted, if the target is less
        than the value in current position, then the target can not in the entire column because the
        column is sorted too. We can rule out one row or one column each time,
        so the time complexity is O(m+n).
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;

        int row = 0;
        int col = matrix[0].length - 1;

        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col])
                return true;
            else if (target < matrix[row][col])
                col--;
            else if (target > matrix[row][col])
                row++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                                        {1, 4, 7, 11, 15},
                                        {2, 5, 8, 12, 19},
                                        {3, 6, 9, 16, 22},
                                        {10, 13, 14, 17, 24},
                                        {18, 21, 23, 26, 30}
                                     };
        System.out.println(searchMatrix(matrix, 30));
    }
}
