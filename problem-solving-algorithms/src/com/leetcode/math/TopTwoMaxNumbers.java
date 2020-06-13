package com.leetcode.math;

import java.util.Arrays;
import java.util.List;

public class TopTwoMaxNumbers {
    public static void main(String[] args) {
        int max1 = 0, max2 = 0;
        Integer[] numArr = new Integer[]{2,1,3};
        List<Integer> nums = Arrays.asList(numArr);
        for(int currentNum : nums) {
            if(max1 < currentNum) { // 1 -> max1 = 3, max2 = 0 // 2 -> max1 = 3, max2 = 2 // 3 -> max1 = 0, max2 = 0
                max2 = max1;
                max1 = currentNum;
            } else if(max2 < currentNum) {
                max2 = currentNum;
            }
        }
        System.out.println("1st max number : " +max1);
        System.out.println("2nd max number : " +max2);
    }
}
