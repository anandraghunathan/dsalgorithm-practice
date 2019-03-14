package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num <= 0)
            return false;

        int divisors_sum = 0;
        for(int i = 1; i < num; i++) {
            if(num % i == 0) {
                divisors_sum += i;
            }

            if(divisors_sum > num) {
                return false;
            }
        }
        return divisors_sum == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(496));
    }
}
