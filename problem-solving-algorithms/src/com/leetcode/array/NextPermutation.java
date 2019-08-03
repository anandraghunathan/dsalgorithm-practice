package com.leetcode.array;

/**
 * https://leetcode.com/problems/next-permutation/
 *
 * Time  : O(N), In worst case, only two scans of the whole array are needed.
 * Space : O(1), No extra space is used. In place replacements are done.
 */
public class NextPermutation {
    /**
     *
     * Step 1 - Walk backwards in the given array until we find the first decreasing sequence. When the while loop ends,
     *          i will stand precisely where we need to start the next permutation
     *
     * Step 2 - If i is the first element,
     *                 We skip down to reverse the whole array, since the whole array would be decreasing,
     *                 meaning, we are on our last permutation
     *
     *          If i is NOT the first element,
     *                 1. We have more work to do to find the next greater element (using another pointer starting from
     *                 end of the array) to where i currently stands,
     *                 2. Swap those two elements
     *                 3. Reverse the rest of the elements AFTER the index where i currently stands (i + 1)
     *
     *
     */
    public static int[] nextPermutation(int[] nums) {
        /*
            Grab the index of the 2nd to last element in the array
        */
        int i = nums.length - 2;

        /*
            Walk backwards. Keep walking until we reach the point right
            before the decreasing sequence begins. When this while loop
            ends that is where i will stand
        */
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }

        /*
            If i is not the first element we have more work to do

            If i IS the first element we just skip down to reverse
            the whole array since the WHOLE array would be decreasing
            meaning we are on our last permutation
        */
        if (i >= 0) {

            /*
                Start a pointer at the end of the array, we want to search for
                the smallest item THAT IS GREATER THAN THE ELEMENT AT i
                Why? Why Why Why. The reason why is that we want to know the
                NEXT element that is to be planted where i is sitting. THIS
                WILL ROOT THE NEXT PERMUTATION and represents the smallest change
                we can make thus ensuring we have exactly the next permutation
            */
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            /*
                We swap those elements.

                Now all that is left is to reverse the decreasing section (it
                is already sorted in reverse order) to restore it to the first
                positionality it would be with the new value rooted at i
            */
            swap(nums, i, j);
        }

        /*
            Perform the reversal on the decreasing section now. We pass in i + 1
            since i sits RIGHT BEFORE the decreasing section that is on its final
            permutation
        */
        reverse(nums, i + 1);

        return nums;
    }

    /*
      Reverses from 'start' to the end of the array 'nums'
    */
    private static void reverse(int[] nums, int start) {

        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /*
      Swap helper
    */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 8, 4, 7, 6, 5, 3, 1};
        System.out.print("[ ");
        for(int num: nextPermutation(input)) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
