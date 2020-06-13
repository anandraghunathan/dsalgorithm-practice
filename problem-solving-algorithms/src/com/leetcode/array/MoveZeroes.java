package com.leetcode.array;

public class MoveZeroes {
    public static int[] moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int cur = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                int temp = nums[cur];
                nums[cur++] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }

    public static int[] moveZeroes2(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        while(count < nums.length) {
            nums[count++] = 0;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0,0,1,3,0,1};
        for (int num: moveZeroes(arr)) {
            System.out.print(num + " ");
        }
    }
}
