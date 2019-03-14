package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
    static List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> numbers = new ArrayList<>();
        for(int x = left; x <= right; x++) {
            if(selfDividing(x))
                numbers.add(x);
        }
        return numbers;
    }

    static boolean selfDividing(int x) {
        int originalVal = x;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (pop == 0 || (originalVal % pop) != 0) {
                return false;
            }
        }
        return true;
    }

    /** Initial implementation before referring to the solution */
    /* public List<Integer> selfDividingNumbers(int left, int right) {
        int self = 0;
        List<Integer> numbers = new ArrayList<>();
        for(int x = left; x <= right; x++) {
            int originalVal = x;

            if(!String.valueOf(x).contains("0")) {
                while (x != 0) {

                    int pop = x % 10;
                    x /= 10;

                    if (pop != 0 && (originalVal % pop) != 0) {
                        self++;
                    }
                }

                if (self == 0) {
                    numbers.add(originalVal);
                }
            }

            //resetting original values
            x = originalVal;
            self = 0;
        }
        return numbers;
    } */

    /** Solution from LeetCode */
//    public static List<Integer> selfDividingNumbers2(int left, int right) {
//        List<Integer> ans = new ArrayList();
//        for (int n = left; n <= right; ++n) {
//            if (selfDividing2(n)) ans.add(n);
//        }
//        return ans;
//    }
//    public static boolean selfDividing2(int n) {
//        int x = n;
//        while (x > 0) {
//            int d = x % 10;
//            x /= 10;
//            if (d == 0 || (n % d) > 0) return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        for(Integer number: selfDividingNumbers(70, 708)) {
            System.out.print(number.toString()+ ",");
        }

        System.out.println("\n");

//        for(Integer number: selfDividingNumbers2(70, 708)) {
//            System.out.print(number.toString()+ ",");
//        }
//        System.out.println("\n");
    }
}
