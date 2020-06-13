package com.leetcode.array;

public class FindTheDuplicateNumber {
    // Change the number at the previous index of the current number to a negative number.
    public static int findDuplicate1 (int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0)
                return Math.abs(nums[i]);
            else
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }
        return -1;
    }

    // Floyd's Tortoise and Hare (Cycle Detection)
    public static int findDuplicate2(int[] nums) {
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
        System.out.println(findDuplicate1(new int[]{2,5,9,6,9,3,8,9,7,1}));
        //System.out.println(findDuplicate1(new int[]{1,3,4,2,2}));
    }
}
