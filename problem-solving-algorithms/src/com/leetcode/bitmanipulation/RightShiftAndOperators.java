package com.leetcode.bitmanipulation;

public class RightShiftAndOperators {
    public static void main(String[] args) {

        int number = 5, result;

        System.out.println("Shift Right Operator");
        System.out.println(Integer.toBinaryString(number >> 0));
        System.out.println(Integer.toBinaryString(number >> 1));
        System.out.println(Integer.toBinaryString(number >> 2));
        System.out.println(Integer.toBinaryString(number >> 3));


        System.out.println("And Operator");
        System.out.println(Integer.toBinaryString(number >> 0 & 1));
        System.out.println(Integer.toBinaryString(number >> 1 & 1));
        System.out.println(Integer.toBinaryString(number >> 2 & 1));
        System.out.println(Integer.toBinaryString(number >> 3 & 1));
    }
}
