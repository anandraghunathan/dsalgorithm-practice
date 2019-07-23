package com.leetcode.string;

import java.util.Stack;

/**
 * Created by Anand Raghunathan on 2019-07-23
 */
public class BasicCalculator {
    public static int calculate(String s) {
        int len = s.length();

        if(s == null || len == 0)
            return 0;

        // Stack to perform the calculation
        Stack<Integer> stack = new Stack<>();

        // num and sign to store the current num and sign based on the current string index
        int num = 0;
        int sign = 1;

        // To store the result
        int res = 0;

        for (int i = 0; i < len; i++) {

            // Store the current number/sign in current index
            char c = s.charAt(i);

            // Handle the numbers case
            if (Character.isDigit(c)) {

                // num * 10 to handle numbers greater than 1 digit
                num = 10 * num + (c - '0');

            }

            // To handle whitespaces that will be ignored
            else if (c == ' ') {
                continue;
            }

            // If the character at the current index is '+'
            else if(c == '+') {

                /*
                    Based on the sign value, the num computed in the previous step is
                    added to the res
                */
                res += sign * num;

                // Reset num and sign to its addition value that is 1
                num = 0;
                sign = 1;
            }

            else if(c == '-') {
                /*
                    Based on the sign value, the num computed in the previous step is
                    deducted from the res
                */
                res += sign * num;

                // Reset num and sign to its decrement value that is -1
                num = 0;
                sign = -1;
            }

            // Open bracket
            else if(c == '(') {
                // we push the res first and then the sign
                stack.push(res);
                stack.push(sign);

                // Reset the res and sign to its original value to compute the value in the parentheses
                res = 0;
                sign = 1;
            }

            else if(c == ')') {
                /*
                    Based on the sign value, either the num computed in the previous step is added to or
                    deducted from the res
                */
                res += sign * num;

                // Reset the num to its original value;
                num = 0;

                // First stack.pop() is the sign before the parenthesis
                res *= stack.pop();

                // Second stack.pop() is now the res calculated before the parenthesis
                res += stack.pop();
            }
        }

        // To handle test cases without brackets like 1 + 1
        if(num != 0)
            res += sign * num;

        return res;
    }

    public static void main(String[] args) {
        //System.out.println(calculate("(1 + 1)"));
        System.out.println(calculate("(1+(4+5+2)"));
    }
}
