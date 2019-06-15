package com.leetcode.math;

public class PowerOfTwoThreeFour {
    public static boolean isPowerOfTwo(int n) {
        /**
         * We know from the input that n is an integer. Integer's max value is
         * (2 ^ 31 / 2) - 1 postive numbers with 0 as a positive integer.
         * Range from -2,147,483,648 to 2,147,483,647. Therefore, we know a number
         * that's power of 2 should be less than 2,147,483,648. And that number
         * is 2 ^ 30 as 2 ^ 31 goes above the Integer.MAX_VALUE. By checking against
         * this 2 ^ 30 = 1073741824, we can find if the number is a power of 2.
         */
        return (n > 0 && 1073741824 % n == 0);
    }

    public static boolean isPowerOfThree(int n) {
        /**
         * We know from the input that n is an integer. Integer's max value is
         * (2 ^ 31 / 2) - 1 postive numbers with 0 as a positive integer.
         * Range from -2,147,483,648 to 2,147,483,647. Therefore, we know a number
         * that's power of 3 should be less than 2,147,483,648. And that number
         * is 3 ^ 19 as 3 ^ 20 goes above the Integer.MAX_VALUE. By checking against
         * this 3 ^ 19 = 1162261467, we can find if the number is a power of 3.
         */
        return (n > 0 && 1162261467 % n == 0);
    }

    public static boolean isPowerOfFour(int num) {
        //0x55555555 is to get rid of those power of 2 but not power of 4
        //so that the single 1 bit always appears at the odd position 15 = 1073741824, we can find if the number is a power of 4.
        System.out.println((num&(num-1)));
        System.out.println(num & 0x55555555);

        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        //System.out.println(isPowerOfTwo(16));
        //System.out.println(isPowerOfThree(16));
        System.out.println(isPowerOfFour(16));

    }
}
