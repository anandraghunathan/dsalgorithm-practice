package com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem specifics: Write an algorithm that runs at O(n) runtime with O(1) space.
 *
 */
public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        if(nums.length == 0)
            return missingNumbers;

        for(int i = 0; i < nums.length; i++) {
            // Elements of the array is 1 to n, so subtracting 1 yields 0 to n - 1, which are essentially the indexes of the array
            int val = Math.abs(nums[i]) - 1;
            // check if the numbers in the array corresponding to the val index is greater than 0
            if(nums[val] > 0)
                // Mark the number as a negative number
                nums[val] = -nums[val];
        }

        // Again iterate through the modifed in-place array
        for(int i = 0; i < nums.length; i++) {
            // Check if the number is not a negative number, if its not then we have never seen that index before
            if(nums[i] > 0)
                // Increment + 1 to the array index and add that missing numbers list
                missingNumbers.add(i+1);
        }
        return missingNumbers;
    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
