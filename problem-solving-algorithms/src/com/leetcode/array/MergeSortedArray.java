package com.leetcode.array;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = (m + n) - 1;
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        /* EDGE CASE:
            When nums1 is empty and nums2 has an element in the array,
            the nums2 element has to be pushed into the index of the nums1
        */
        while(j >= 0)
            nums1[k--] = nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};

        merge(nums1, 3, nums2, 3);

        for(int num : nums1) {
            System.out.print(num + ", ");
        }
    }
}
