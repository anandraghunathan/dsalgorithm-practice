package com.leetcode.slidingwindow;

/**
 * Created by Anand Raghunathan on 2019-09-13
 *
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence
 *
 * Intuition:
 *          The idea is to use count to record the length of the current continuous increasing subsequence
 *          which ends with nums[i] > nums[i - 1], and use res to record the maximum count.
 *
 * Time  : O(n), one-pass
 * Space : O(1), constant space
 *
 */
public class LongestContinousIncreasingSubsequence {
    /*

    */
    public int findLengthOfLCIS(int[] nums) {
        // Sliding window
        int count = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] > nums[i - 1]) {
                res = Math.max(res, ++count);
            } else {
                count = 1;
            }
        }
        return res;
    }
}
