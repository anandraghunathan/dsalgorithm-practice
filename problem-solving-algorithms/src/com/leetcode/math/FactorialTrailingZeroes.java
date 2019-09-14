package com.leetcode.math;

/**
 *
 * Intuition:
 *      The ZERO comes from 10.
 *      The 10 comes from 2 x 5
 *      We need to account for all the products of 5 and 2. like for 20, it's a product of 4 × 5.
 *      In n!, we need to know how many 2 and 5, and the number of zeros is the minimum of the number of 2 and the number of 5.
 *      Since multiple of 2 is more than multiple of 5, the number of zeros is dominant by the number of 5.
 *      So, if we take all the numbers with 5 as a factor, we'll have way more than enough even numbers to pair with
 *      them to get factors of 10
 *
 *  Detailed explanation with examples:
 *      https://leetcode.com/problems/factorial-trailing-zeroes/discuss/52373/Simple-CC%2B%2B-Solution-(with-detailed-explaination)
 *
 */
public class FactorialTrailingZeroes {
    /**
     * Iterative approach
     *
     *  Time  : O(log N)
     *  Space : O(1)
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while(n/5 > 0) {
            n = n / 5;
            count += n;
        }
        return count;
    }

    /**
     *  Recursive approach
     *
     *  Time  : O(log N)
     *  Space : O(log N), since this is not a tail recursion
     */
    public int trailingZeroesRecursive(int n) {
        return n == 0 ? 0 : n /5 + trailingZeroesRecursive(n / 5);
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes obj = new FactorialTrailingZeroes();
        System.out.println(obj.trailingZeroes(4617));
    }
}
