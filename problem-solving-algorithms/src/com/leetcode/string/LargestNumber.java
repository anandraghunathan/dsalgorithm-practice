package com.leetcode.string;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    private static class LargerNumberComparator implements Comparator<String> {
        @Override
        /**
         *
         *  Input  - 3, 30, 34, 5, 9
         *  Output - 9, 5, 34, 3, 30
         *
         *      Comparisons
         *
         *      3, 30  - 330
         *
         *      34, 30 - 3430 (twice)
         *
         *      34, 3  - 343
         *
         *      5, 3   - 53
         *
         *      5, 34  - 534
         *
         *      9, 3   - 93
         *
         *      9, 34  - 934
         *
         *      9, 5   - 95
         */
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public static String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        return largestNumberStr;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
