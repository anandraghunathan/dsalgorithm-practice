package com.leetcode.array;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesInArray {
    // Function to remove duplicate elements
    // This function returns new size of modified
    // array.
    static int removeDuplicates(int nums[])
    {
        // Return, if array is empty
        // or contains a single element
        int n = nums.length;
        if (n==0 || n==1)
            return n;

        int[] tmp = new int[n];

        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++) {
            // If current element is not equal
            // to next element then store that
            // current element
            if (nums[i] != nums[i + 1])
                tmp[j++] = nums[i];
        }
        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        tmp[j++] = nums[n-1];

        // Modify original array
        for (int i=0; i<j; i++) {
            nums[i] = tmp[i];
        }
        return j;
    }

    public static int removeDuplicates2(int[] nums) {
        int j = 0;
        int n = nums.length;
        for(int i = 1; i < n; i++) {
            if(nums[i] != nums[j])
                nums[j++] = nums[i];
        }
        return j + 1;
    }

    public static void main(String[] args) {
        //int nums[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int nums[] = {1, 1, 2};
        int n = nums.length;

        // Print updated array
        System.out.print("Input Array  : ");
        for (int i=0; i<n; i++)
            System.out.print(nums[i]+ "  ");

        System.out.println();

        n = removeDuplicates2(nums);

        System.out.print("Output Array : ");
        // Print updated array
        for (int i=0; i<n; i++)
            System.out.print(nums[i]+ "  ");
    }
}
