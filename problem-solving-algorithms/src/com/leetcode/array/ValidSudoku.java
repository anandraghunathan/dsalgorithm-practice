package com.leetcode.array;

import java.util.HashSet;

/**
 *
 * https://leetcode.com/problems/valid-sudoku/
 *
 * Full explanation: https://leetcode.com/problems/valid-sudoku/discuss/15450/Shared-my-concise-Java-code/15493
 *
 * Explanation for Line no:  33, 34 and 35 is below.
 *
 * The first two lines is intended to get all top left corner index of nine cubics. It is a trick here.
 *
 * When you traverse i from 0 to 8. Here RowIndex and ColIndex will traverse through all the possible top left index of the cubics.
 *
 * The third line is intended to get traverse through all the elements in the cubic confirmed by the i in the first lines.
 * When j traverse from 0 - 8, it will just traverse through all possible index of the cubic assigned by the fixed i value in the outer loop.
 *
 * This solution is very tricky, the definition of i, j varies between loops and that's also why he can get such a concise solution.
 *k12
 */

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3 * (i/3);
                int ColIndex = 3 * (i%3);
                if(board[RowIndex + j/3][ColIndex + j%3] != '.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]
                                        {
                                                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                                                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                                                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                                                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                                                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                                                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                                                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                                                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                                                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                                        };
        System.out.println(isValidSudoku(board));
    }
}
