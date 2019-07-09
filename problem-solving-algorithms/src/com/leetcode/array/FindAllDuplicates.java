package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicates {
    // when find a number i, flip the number at position i-1 to negative.
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> dup = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            // If the number at index postion is negative, this number occurs twice
            if (nums[index] < 0)
                dup.add(index + 1);
            // Flip the number to a negative number
            nums[index] = -nums[index];
        }
        return dup;
    }

    public static void main(String[] args) {
        for(Integer dup : findDuplicates(new int[]{4,3,2,7,8,2,3,1})) {
            System.out.print(dup + ", ");
        }
    }
}
