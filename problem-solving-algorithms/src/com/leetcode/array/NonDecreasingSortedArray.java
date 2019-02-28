package com.leetcode.array;

public class NonDecreasingSortedArray {
    public static int[] sortedSquares(int[] A) {
        int n = A.length;
        int i = 0;
        int j = n - 1;
        int[] sa = new int[n];
        for (int x = n - 1; x >= 0; x--) {
            // sys out added for understanding purpose
            System.out.println("Counter of i - " + i + " with Val - "+ Math.abs(A[i]));
            System.out.println("");
            System.out.println("Counter of j - " + j + " with Val - "+ Math.abs(A[j]));
            System.out.println("");
            System.out.println("Counter of x - " + x + " with Val \n");
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                sa[x] = A[i] * A[i];
                i++;
            } else {
                sa[x] = A[j] * A[j];
                j--;
            }
            // for loop added for understanding purpose
            for(int a: sa) {
                System.out.print(a + " \n\n");
            }
        }
        return sa;
    }

    public static void main(String[] args) {
       sortedSquares(new int[]{-7,-3,2,3,11});
    }
}
