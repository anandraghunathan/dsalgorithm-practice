package com.leetcode.binarysearch;

/**
 * Created by Anand Raghunathan on 2019-07-15
 *
 * https://leetcode.com/problems/search-a-2d-matrix
 *
 * Time: O(log(m) + log(n)), where m is the number of rows and n is the number of columns
 * Space: O(1)
 */
public class Search2DMatrix {

      /**
          Here is a very pure 2D matrix to exemplify our mapping system. each cell has its conceptual
          index if we flattened the 2D matrix into a 1D sorted array.

          [ 0, 1, 2 ]
          [ 3, 4, 5 ]
          [ 6, 7, 8 ]

          totalRows = 3
          totalColumns = 3

          Coordinate Mappings -> (row, col)

          [ (0, 0), (0, 1), (0, 2) ]
          [ (1, 0), (1, 1), (1, 2) ]
          [ (2, 0), (2, 1), (2, 2) ]

          Given a 1D index position .. we declare our mapping equations:

          row in 2D matrix: 1DIndex / totalColumns
          col in 2D matrix: 1DIndex % totalColumns

          Example:

          We want to find the coordinate for element 6.
          row in 2D matrix: (6) / 3 = 2
          col in 2D matrix: (6) % 3 = 0

          Output: (2, 0)

          We are correct.
    */
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*
            We can't search a matrix with no rows.
            If we have rows then we can continue.
        */

        if (matrix.length == 0) {
            return false;
        }

        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        /*
            The lo and hi pointer to our search. We imagine a visualization
            of a 1D array and will use our mapping system to convert these indices
            into concrete locations in the 2D matrix.
            The the last position in the matrix if we consider it as array will be
            rows * cols - 1 indices.
            Same as an array...an array's last index is arr.length - 1.
        */

        int lo = 0;
        int hi = totalRows * totalColumns - 1;

        /*
            Continue searching while the lo has not passed the hi
        */
        while (lo <= hi) {

            /*
                Prevent overflow, find the mid this way instead of doing: (hi + lo) / 2
            */
            int mid = lo + (hi - lo) / 2;

            /*
                We need to map from our conceptualized 1D array back to our 2D matrix to index
                into it.

                Given a 1D index position .. we declare our mapping equations:

                row in 2D matrix: 1DIndex / totalColumns
                col in 2D matrix: 1DIndex % totalColumns
            */
            int midElementValue = matrix[mid / totalColumns][mid % totalColumns];

            /*
              3 possibilities:
                1.) We found the target
                2.) We went too high in value...go "lo"
                3.) We went too low in value...go "hi"
            */
            if (midElementValue == target) {
                return true; // element found
            } else if (target < midElementValue) {
                hi = mid - 1; // go lo
            } else {
                lo = mid + 1; // go hi
            }
        }

        /*
            If no element is found, we will reach here and return false
        */
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                                        {1},
                                        {3}
                                     };
        System.out.println(searchMatrix(matrix, 3));
    }
}
