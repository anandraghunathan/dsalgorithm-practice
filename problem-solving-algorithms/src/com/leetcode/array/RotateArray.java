package com.leetcode.array;

/**
 * https://leetcode.com/problems/rotate-array/
 */
public class RotateArray {

    /* Solved using 3 steps to rotate the array - Given input array to rotate      -->  [1,2,3,4,5,6,7]
        1. Reverse the entire array from left to right - [7, 6, 5, 4, 3, 2, 1]
        2. Reverse the first k numbers - [5, 6, 7, 4, 3, 2, 1]
        3. Reverse the last n - k numbers - [5, 6, 7, 1, 2, 3, 4]

    */
    public static int[] rotate(int[] nums, int k) {
        // To handle test cases when the given k is greater than nums.length
        k %= nums.length;

        // Reverse the entire array from left to right
        reverse(nums, 0, nums.length - 1);

        // Reverse the first k numbers
        reverse(nums, 0, k - 1);

        // Reverse the last n - k numbers
        reverse(nums, k, nums.length - 1);

        return nums;
    }

    // Reverse numbers in the array
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] res = rotate(new int[]{1,2,3,4,5,6,7}, 3);
        //int[] res = rotate(new int[]{-1,-100,3,99}, 2);
        //int[] res = rotate(new int[]{1,2,3}, 4);
        for(int r : res) {
            System.out.print(r + ", ");
        }
    }
}
