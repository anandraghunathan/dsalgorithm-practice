package com.leetcode.greedy;

public class JumpGame {
    public static boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max)
                return false;
            max = Math.max(A[i]+i,max);
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    public static void main(String[] args) {
        //System.out.println(canJump(new int[]{3,2,1,0,4}));
        System.out.println(canJump2(new int[]{2,3,1,1,4}));
    }
}
