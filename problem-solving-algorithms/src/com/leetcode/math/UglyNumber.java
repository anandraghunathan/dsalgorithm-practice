package com.leetcode.math;

public class UglyNumber {
    public static boolean isUgly(int num) {
        // Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
        for(int i = 2; i < 6 && num > 0; i++) {
            while(num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(25));
    }
}
