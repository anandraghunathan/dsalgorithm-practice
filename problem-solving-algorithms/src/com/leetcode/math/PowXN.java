package com.leetcode.math;

/**
 * https://leetcode.com/problems/powx-n
 *
 * Time  : O(logN)
 * Space : O(1)
 */
public class PowXN {
    public static double pow(double x, int n) {
        if(n == 0)
            return 1;

        // If n is an integer min value
        if(n == Integer.MIN_VALUE) {
            n = n/2;
            x = x * x;
        }

        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        if(n % 2 == 0)
            return pow(x * x, n/2);
        else
            return x * pow(x * x, n/2);
    }

    public static void main(String[] args) {
        System.out.println(pow(2.10000, 3));
    }
}
