package com.leetcode.hard;

import java.util.HashSet;

/**
 * Runtime: O(n)
 * Space  : O(n)
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {

        if(nums.length == 0)
            return 0;

        HashSet<Integer> hashSet = new HashSet();

        for(int num : nums)
            hashSet.add(num);

        int longestStreak = 1;

        for(int num : nums) {
            // Start counting the streak only when the set doesn't contain the number one less than the current number
            if(!hashSet.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                // Get into the loop only when the set contains the current number's next number. Ex: 1, 2 or 3, 4
                while(hashSet.contains(currentNum + 1)) {
                    currentStreak += 1;
                    currentNum += 1;

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{8}));
    }
}
