package com.leetcode.array;

public class nRepeatedElement {
    public static int repeatedNTimes(int[] A) {
        for (int i=0; i<A.length-2; i++)
            if(A[i] == A[i+1] || A[i] == A[i+2])
                return A[i];
        return A[A.length-1];
    }

    public static void main(String[] args) {
        System.out.print(repeatedNTimes(new int[]{1, 3, 5, 8, 2, 2}));
    }
}
