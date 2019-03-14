package com.leetcode.array;

public class PlusOne {

    /** Mediocre solution */
    public static int[] plusOneAnand(int[] digits) {
        int n = digits.length - 1;
        int[] carryDigit = {0, 0};
        for(int i = n; i >= 0; i--) {
            if(n < 1) {
                if (digits[i] < 9) {
                    digits[i]++;
                    return digits;
                } else {
                    return new int[]{1, 0};
                }
            }

            if(i == n) {
                carryDigit = carryNumber(digits[i]);
                digits[i] = carryDigit[0];
                continue;
            }

            if (carryDigit[1] > 0) {
                if(digits[i] + 1 == 10) {
                    carryNumber(digits[i]);
                    digits[i] = carryDigit[0];
                } else {
                    digits[i]++;
                    carryDigit[1] = 0;
                }
            }

            if((i == 0) && (carryDigit[1] > 0)) {
                if(digits[i] == 0) {
                    int[] newArr = new int[digits.length + 1];
                    newArr[0] = 1;
                    return newArr;
                }
            }

        }
        return digits;
    }

    public static int[] carryNumber(int digit) {
        int carry = 0;
        if(digit + 1 == 10) {
            carry = 1;
            digit = 0;
        } else {
            digit++;
            carry = 0;
        }
        return new int[]{digit, carry};
    }

    /** Best solution */
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // gets called only when all the elements of the input array are 9s'
        int[] newArr = new int[n + 1];
        newArr[0] = 1;

        return newArr;
    }

    public static void main(String[] args) {
        for(int digit: plusOne(new int[]{9,9}))
            System.out.print(digit +", ");
    }
}
