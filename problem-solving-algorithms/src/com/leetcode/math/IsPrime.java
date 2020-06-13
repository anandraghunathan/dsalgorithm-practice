package com.leetcode.math;

public class IsPrime {
    public static boolean isPrime(int n) {
        // 11
        for(int i = 2; i < n; i++) {
            if(n % i == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(11));
    }
}
