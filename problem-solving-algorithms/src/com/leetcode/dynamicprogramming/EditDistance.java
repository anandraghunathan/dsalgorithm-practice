package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 *
 * Time  : O(m * n)
 * Space : O(m * n)
 */
public class EditDistance {
    /**
     *
     *
     * Solved using dynamic programming as it involves solving the smaller sub-problems to eventually solve the larger problem
     *
     * s = "horse"
     * p = "ros"
     *
     */
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int minMoves[][] = new int[m + 1][n + 1];

        // Fill up the 2D matrix with default values for the 0th index for both row and column of the table
        for(int j = 0; j < minMoves[0].length; j++) {
            minMoves[0][j] = j;
        }

        for(int i = 0; i < minMoves.length; i++) {
            minMoves[i][0] = i;
        }

        // Iterate through the word1 and word2
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                /*
                    If:
                        The word1's current index character is the same as the word2's
                        character at the same index, then we assign the value in minMoves[i-1][j-1]
                        cell to the current index. Basically, the diagonal cell to the current cell
                        of the 2D matrix.

                        This means, there is no editing required for this character.

                    Else:
                        1. We have to find the minumum of the 3 indices,
                            a. minMoves[i-1][j-1]
                            b. minMoves[i-1][j]
                            c. minMoves[i][j-1]
                        2. Add 1 to the min of the 3 cells and assign that value to the current
                            index.

                */
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minMoves[i][j] = minMoves[i - 1][j - 1];
                } else {
                    minMoves[i][j] = 1 + min(minMoves[i-1][j-1], minMoves[i-1][j], minMoves[i][j-1]);
                }
            }
        }
        // Return the bottom right most cell value from the 2D matrix we generated
        return minMoves[m][n];
    }

    /*
        To find the min value of the 3 cells,
            1. Top left cell - [i-1][j-1]
            2. Top cell - [i-1][j]
            3. Left cell - [i][j-1]
    */
    private static int min(int replace, int insert, int remove) {
        int min = Math.min(replace, insert);
        return Math.min(min, remove);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }
}
