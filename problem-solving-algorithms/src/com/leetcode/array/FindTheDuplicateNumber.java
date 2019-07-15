package com.leetcode.array;

public class FindTheDuplicateNumber {
    // Floyd's Tortoise and Hare (Cycle Detection)
    public static int findDuplicate(int[] nums) {
        // Find the intersection index of the two pointers.
        int fast = 0;
        int slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast)
                break;
        }
        // Find the "entrance" to the cycle.
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
    }
}
