package com.leetcode.dynamicprogramming;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] bucket = new int[n];
        for(int num : nums) {
            bucket[num] += num;
        }

        int preRob = 0, preNotRob = 0;
        for(int i = 0; i < n; i++) {
            int rob = preRob, notRob = preNotRob;
            preRob = notRob + bucket[i];
            preNotRob = Math.max(notRob, rob);
        }
        return Math.max(preNotRob, preRob);
    }

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        System.out.println(obj.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
