package com.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 *  Solved - 21 Sep 2019
 *
 *  https://leetcode.com/problems/split-array-into-consecutive-subsequences/ - Classic greedy approach
 *
 *  Intuition and Algorithm:
 *     To all who are confused why we should put 'append existed split' part before 'create a new split' part.
 *     Generally, this is followed by a strict mathematics proof but intuitively you can think in this way.
 *     Given example '1 2 3 3 4 4 5 5' the greedy way to handle this is by appending '1 2 3' with '4 5' and what's
 *     left is '3 4 5' then we're done. However, if you stop by '1 2 3' and when you see the second '3' you create a
 *     new split that is '3 4 5' then we fail ('4 5' are left). This example illustrates why you should adopt 'append'
 *     strategy first.
 *
 *     Is there any example we should stop immediately when we have three numbers in a split?
 *         Yes, given '1 2 3 3 4 5', you might not scan till the end to format '1 2 3 4 5', otherwise '3' will be alone.
 *         However, our strategy also works in some way. Once it reaches the second '3' it will automatically add '4' to
 *         apendfreq which means we've already finished '1 2 3' and let's start a new split.
 *
 *  Another explanation with example:
 *     Here is how I see "appendfreq"
 *
 *     eg: [1,2,3,4,5]
 *       i = 1
 *          we fall in 3 case "start of a new subsequence"
 *          we make 2, 3 freq 0
 *          and put <4, 1> in appendfreq, this mean I have 1 subsequence can continue from 4
 *
 *       i = 2, 3
 *          we continue
 *
 *       i = 4
 *          we fall in 2 case since <4, 1> is in appendfreq
 *          now this subsequence should end in 5
 *          so we decrease <4, 1> to <4, 0> since we no longer have subsequence can continue from 4
 *          and we put <5, 1> in appendfreq since now we have a subsequence can continue from 5
 *
 *  Time  : O(N), where N is the length of nums. We iterate over the array.
 *
 *  Space : O(N), the size of freq and appendfreq
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>(), appendfreq = new HashMap<>();
        for (int i : nums)
            freq.put(i, freq.getOrDefault(i,0) + 1);
        for (int i : nums) {
            if (freq.get(i) == 0) // continue if the count of the current num is 0
                continue;
            // we check the appendfreq ("future" map) for the current num's count if its > 0, before we create a new split (case 3)
            else if (appendfreq.getOrDefault(i,0) > 0) {
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1,0) + 1);
            }
            // Check greedily the next two subsequent numbers in the map if they have count > 0
            else if (freq.getOrDefault(i+1,0) > 0 && freq.getOrDefault(i+2,0) > 0) {
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i+3, appendfreq.getOrDefault(i+3,0) + 1);
            }
            // If the current num doesn't fall into any of the previous 3 conditions, we can't split the array so return false
            else {
                return false;
            }
            // processed the current index, so decrement the count of the current num
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArrayIntoConsecutiveSubsequences obj = new SplitArrayIntoConsecutiveSubsequences();
        System.out.println(obj.isPossible(new int[]{1,2,3,3,4,4,5,5}));
    }
}
