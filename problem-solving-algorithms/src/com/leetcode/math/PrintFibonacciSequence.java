package com.leetcode.math;

public class PrintFibonacciSequence {
    public static int fibRecursive(int n) {
        if(n <= 1)
            return n;

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static int fibIteratively(int n) {
        if(n <= 1)
            return n;
        int a = 0, b = 1, sum = 0;
        while(n > 1) {
            sum = a + b;
            a = b;
            b = sum;
            n--;
        }
        return sum;
    }

    // 1, 1, 2, 3
    public static void main(String[] args) {
        int n = 5;
        for(int i = 0; i < n; i++) {
            //System.out.print(fibRecursive(i) + " ");
            System.out.print(fibIteratively(i) + " ");
        }
    }
}
