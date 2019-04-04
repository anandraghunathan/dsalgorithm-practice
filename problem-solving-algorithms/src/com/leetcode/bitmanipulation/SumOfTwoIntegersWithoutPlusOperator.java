package com.leetcode.bitmanipulation;

public class SumOfTwoIntegersWithoutPlusOperator {
    public static int sumOfIntegers(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;

        while(b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(sumOfIntegers(24, 65));
    }
}
