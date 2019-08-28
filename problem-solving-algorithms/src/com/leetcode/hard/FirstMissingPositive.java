package com.leetcode.hard;

/**
 * Created by Anand Raghunathan on 2019-08-26
 *
 * https://leetcode.com/problems/first-missing-positive/
 *
 * Time  : O(n), we shouldn't interpret the time complexity from how many while/for-loop. We should consider time
 *          complexity from the number/scale of the operations. In this case, each number will be swapped at most once,
 *          so it is O(n)
 * Space : O(1), we aren't utilizing any extra space here
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Each number will be swapped at the most only once. So we do the swap in O(N) time
        for(int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                /*
                    Pass current index i, and current num value index. Ex: if nums[i] = 5, for the array [1, 2, 3, 5, 4],
                    we pass current index 3, and num value index 4 to the swap method with the nums array
                 */
                swap(nums, i, nums[i] - 1);
            }
        }

        /*
            To handle arrays like, [7,8,9,11,12], we return 1 as the first smallest missing positive number

            Also to handle arrays like, [1, 2, 0]. After the below if condition validated to true for i = 0, 1,
            as nums[0] = i + 1 (1), and nums[1] = i + 1 (2), but for 3, it finds the nums[i] ! = i (2) + 1,
            therefore return i + 1 -> 3 as the next smallest missing positive number
         */

        for(int i = 0; i < n; i++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        /*
            If there is no swap required for the given array, return the next positive integer that's not present
            in the given array. Example: Given nums array [1, 2, 3, 4, 5], return 6, the next smallest positive integer
         */
        return n + 1;
    }

    private void swap(int[] nums, int currentIndex, int currNumValueIndex) {
        int temp = nums[currentIndex];
        nums[currentIndex] = nums[currNumValueIndex];
        nums[currNumValueIndex] = temp;
    }

    public static void main(String[] args) {
        FirstMissingPositive obj = new FirstMissingPositive();
        //System.out.println(obj.firstMissingPositive(new int[]{7,8,9,11,12}));
        //System.out.println(obj.firstMissingPositive(new int[]{1, 2, 0}));
        //System.out.println(obj.firstMissingPositive(new int[]{3, 4, -1, 1}));
        //System.out.println(obj.firstMissingPositive(new int[]{1, 2, 3, 5, 4}));
        System.out.println(obj.firstMissingPositive(new int[]{1, 2, 3, 4, 5}));
    }
}
