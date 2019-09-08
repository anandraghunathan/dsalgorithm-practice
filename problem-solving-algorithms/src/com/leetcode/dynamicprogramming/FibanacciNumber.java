package com.leetcode.dynamicprogramming;

public class FibanacciNumber {
    /**
     https://leetcode.com/problems/fibonacci-number

     Intuition:
     Improve upon the recursive option by using iteration, still solving for all of the
     sub-problems and returning the answer for N, using already computed Fibonacci values.
     In using a bottom-up approach, we can iteratively compute and store the values, only
     returning once we reach the result.

     Algorithm:
     If N is less than or equal to 1, return N
     Otherwise, iterate through N, storing each computed answer in an array along the way.
     Use this array as a reference to the 2 previous numbers to calculate the current
     Fibonacci number.
     Once we've reached the last number, return it's Fibonacci number.

     Time  : O(N). Each number, starting at 2 up to and including N, is visited, computed and
     then stored for O(1) access later on.
     Space : O(N). The size of the data structure is proportionate to N.
     */
    public int fib(int N) {
        if(N < 2)
            return N;

        int[] memo = new int[N + 1];

        memo[0] = 0;
        memo[1] = 1;

        for(int i = 2; i <= N; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }
}
