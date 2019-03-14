package com.other;

import java.util.HashSet;
import java.util.Set;

public class NumbersPairSum {
    public static int[] numbersPairSum(int[] nums, int target) {
        Set<Integer> numSet = new HashSet<>();
        int[] complementArr = {};
        for(int i = 0; i < nums.length; i++) {
           int complement = target - nums[i];
            if(numSet.contains(nums[i])) {
                //return true;
                complementArr = new int[]{complement, nums[i]};
            }
            numSet.add(complement);
        }
        //return false;
        return complementArr;
    }

    public static void main(String[] args) {
        //System.out.println(numbersPairSum(new int[]{1, 2, 4, 3, 5, 8, 9}, 8));
        for(int num : numbersPairSum(new int[]{1, 3, 4, 2, 5, 8, 9}, 8)) {
            System.out.print(num + ", ");
        }
    }
}
