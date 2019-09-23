package com.leetcode.greedy;

/**
 *  https://leetcode.com/problems/lemonade-change
 *
 *  Time  : O(N), one-pass
 *  Space : O(1), no extra space
 */
public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int bill : bills) {
            if(bill == 5) {
                five += 1;
            } else if(five > 0 && bill == 10) {
                ten += 1;
                five -= 1;
            } else if(ten > 0 && five > 0) {
                ten -= 1;
                five -= 1;
            } else if(five >= 3) {
                five -= 3;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange obj = new LemonadeChange();
        System.out.println(obj.lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
