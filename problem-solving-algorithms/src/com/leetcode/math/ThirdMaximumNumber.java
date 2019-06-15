package com.leetcode.math;

public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        Integer firstmax = Integer.MIN_VALUE;
        Integer secondmax = Integer.MIN_VALUE;
        Integer thirdmax = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num > firstmax) {
                thirdmax = secondmax;
                secondmax = firstmax;
                firstmax = num;
                //System.out.println("firstmax: " +firstmax);
            } else if (num > secondmax && num != firstmax) {
                thirdmax = secondmax;
                secondmax = num;
                //System.out.println("secondmax: " +secondmax);
            } else if(num > thirdmax && num != secondmax && num != firstmax) {
                thirdmax = num;
                //System.out.println("thirdmax: " +thirdmax);
            }
        }

        if(nums.length < 3) {
            return firstmax;
        }
        return thirdmax > Integer.MIN_VALUE ? thirdmax : firstmax;
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[] {1,2,2,5,3,5}));
    }
}
