package com.leetcode.binarysearch;

/**
 * https://leetcode.com/problems/sqrtx
 */
public class Sqrtx {
    public static int mySqrt(int x) {
        int lo = 1, hi = x;

        // continue searching while [lo,hi] is not empty
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;

            /* x/mid is done to calculate the square root number.
                1. If mid (4) is equal to x(8)/mid(2), return the mid number
                2. If mid (4) is smaller than x(8)/mid(2), increment the lo counter
                3. If mid (4) is greater than x(8)/mid(2), decrement the hi counter
             */
            if(mid == x/mid)
                return mid;
            else if(mid < x/mid)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        // return the hi (right) counter cause we have to keep exploring lo > hi
        return hi;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
