package com.leetcode.array;

public class RotateImage {
    public static int[][] rotate(int[][] matrix) {

        // Transpose the matrix first
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i; j < matrix[i].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // After transpose as the first step, flip the matrix next.
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length/2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                            {1,2,3},
                            {4,5,6},
                            {7,8,9}
                         };
        matrix = rotate(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] +", ");
            }
        }
    }
}
