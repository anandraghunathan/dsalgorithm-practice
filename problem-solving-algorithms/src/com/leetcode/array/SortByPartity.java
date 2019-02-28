package com.leetcode.array;

public class SortByPartity {

    public static void main(String[] args) {
        sortArrayByParity(new int[]{0, 2, 1, 4});
    }

    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            if(A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }
        for(int pair : A) {
            System.out.print(" "+pair);
            System.out.print(" ");
        }
        return A;
    }
}
