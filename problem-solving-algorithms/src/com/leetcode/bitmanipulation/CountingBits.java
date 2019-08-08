package com.leetcode.bitmanipulation;

/**
 * https://leetcode.com/problems/counting-bits/
 * Time  : O(n)
 * Space : O(n)
 */
public class CountingBits {

    /**
     *
     *  As we know, a number can be classified into an even or odd number.
     *
     *  An even number in binary ends with 0
     *
     *  An odd number in binary ends with 1
     *
     */
    public static int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;

        for(int i = 1; i <= num; i++){
            /*
                even - If it is even, the ending bit is 0, then that bit can be ignored,
                       countBits(num) is the same as countBits(num >> 1), so countBits(num) = countBits(num >> 1);
             */
            if((i & 1) == 0){
                res[i] = res[i >> 1];
            }
            /*
                odd - If it is odd, the ending bit is 1, then the number of set bits is that of num - 1 + 1,
                      i.e. countBits(num) = countBits(num - 1) + 1
             */
            else {
                res[i] = res[i - 1] + 1;
            }
        }

        /**
         * The above if and else can be merged into one statement
         *  res[i] = res[i >> 1] + (i & 1)
         *
         *  res[i] = res[i >> 1] + (i & 1) -> means, res[i] = res[i / 2] + (res % 2)
         *
         *  In other words, res[binary string without the last bit] + last bit is 1 or not
         *
         *  Divide it in 2 parts:
         * <1> the last digit (1 or 0, which is "i & 1", equivalent to "i % 2" )
         * <2> the other digits (the number of 1, which is "res[i >> 1] ", equivalent to "res[i/2]")
         */
        return res;
    }

    public static void main(String[] args) {
        System.out.print("[");
        for(int num : countBits(5)) {
            System.out.print(num + " ");
        }
        System.out.print("]");
    }
}
