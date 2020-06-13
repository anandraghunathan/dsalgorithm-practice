package com.leetcode.math;

public class AddDigits {
    public static int addDigits1(int num) {
        int addedSum, remain;
        while(true) {
            addedSum = 0;
            while(num > 0) {
                remain = num % 10;
                addedSum += remain;
                num = num / 10;
            }
            if(addedSum > 9)
                num = addedSum;
            else
                return addedSum;
        }
    }

    public static int addDigits2(int num) {
        while(num > 9)
            num = (num % 10) + (num / 10);
        return num;
    }

    public static void main(String[] args) {
        //System.out.println(addDigits1(38));
        System.out.println(addDigits2(38));
    }
}
