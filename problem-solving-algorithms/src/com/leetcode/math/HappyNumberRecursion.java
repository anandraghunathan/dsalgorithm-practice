package com.leetcode.math;

public class HappyNumberRecursion {
    public static boolean isHappy(int n) {
        if(n == 1 || n == 7) {
            return true;
        } else if (n < 10) {
            return false;
        }

        int sum = 0;
        while(n != 0) {
            int mod = n % 10;
            sum += (mod * mod);
            n /= 10;
        }
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
