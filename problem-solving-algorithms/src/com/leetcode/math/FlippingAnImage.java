package com.leetcode.math;

public class FlippingAnImage {
    public static int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A) {
            for (int i = 0; i < (C) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = flipAndInvertImage(new int[][]{{1,1,0,0}, {1,0,0,1}, {0,1,1,1}, {1,0,1,0}});
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[row].length; col++) {
                System.out.print(A[row][col] +", ");
            }
        }
    }
}
