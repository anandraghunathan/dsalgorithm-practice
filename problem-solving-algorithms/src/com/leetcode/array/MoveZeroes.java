package com.leetcode.array;

public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        int insertPos = 0;
        for(int num : nums) {
            if(num != 0) {
                nums[insertPos++] = num;
            }
        }

        while(insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,0,1,3,0,1};
        for (int num: moveZeroes(arr)) {
            System.out.println(num);
        }
    }
}
