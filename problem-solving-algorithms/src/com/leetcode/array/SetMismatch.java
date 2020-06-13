package com.leetcode.array;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[]{-1, -1};
        for(int num : nums) {
            if(nums[Math.abs(num) - 1] < 0)
                res[0] = Math.abs(num);
            else
                nums[Math.abs(num) - 1] *= -1;
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0)
                res[1] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] res = findErrorNums(new int[]{1,2,2,4});
        int[] res = findErrorNums(new int[]{3,2,2});
        for(int r : res)
            System.out.print(r + "  ");
    }
}
