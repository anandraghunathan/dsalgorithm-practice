package com.leetcode.math;

import java.util.HashSet;
import java.util.Set;

/**
 *  https://leetcode.com/problems/happy-number/submissions/
 *
 *  Hash set to record sum of every digit square of every number occurred.
 *  Once the current sum cannot be added to set (to avoid infinite loop), return false;
 *  once the current sum equals 1, return true;
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int squareSum, remain;
        while(set.add(n)) {
            squareSum = 0;
            while(n > 0) {
                remain = n % 10;
                squareSum = squareSum + (remain * remain);
                n = n / 10;
            }
            if(squareSum == 1)
                return true;
            else
                n = squareSum;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
