package com.leetcode.array;

/**
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 *
 * Time  : O(N)
 * Space : O(1)
 */
public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        // start with two largest values, as soon as we find a number bigger than both, while both have been updated, return true.
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small)
                small = num; // update small if num is smaller than both
            else if (num <= big)
                big = num; // update big only if greater than small but smaller than big
            else
                return true; // return if you find a number bigger than both
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,1,2,2,3}));
    }
}
