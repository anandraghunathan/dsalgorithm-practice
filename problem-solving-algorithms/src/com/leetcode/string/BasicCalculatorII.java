package com.leetcode.string;

import java.util.Stack;

/**
 * Created by Anand Raghunathan on 2019-07-23
 *
 * https://leetcode.com/problems/basic-calculator-ii
 *
 * Time  : O(n)
 * Space : O(n)
 *
 */
public class BasicCalculatorII {
    public static int calculate(String s) {
        int len = s.length();

        if(s == null || len == 0)
            return 0;

        // Stack to perform the calculation
        Stack<Integer> stack = new Stack();

        // num and sign to store the current num and sign based on the current string index
        int num = 0;
        char sign = '+';

        for(int i = 0; i < len; i++) {

            // Store the current number/sign in current index
            char c = s.charAt(i);

            // Handle the numbers case
            if(Character.isDigit(c))

                // num * 10 to handle numbers greater than 1 digit
                num = num * 10 + c - '0';

            /** Handle non-numeric case.
                1. If the index is a non-number AND
                2. If entry at the index is NOT a whitespace, we should just ignore and move on (OR)
                3. If the index has reached the end of string
            */
            if(!Character.isDigit(c) && c != ' ' || i == len - 1) {
                /**
                    If the sign is a '+' then we simply push the current num computed
                    in the previous iteration to the stack.

                    If the sign is a '-' then we simply push the current num computed
                    in the previous iteration to the stack with a '-' in front of the num

                    If the sign is a '*' or '/', then we pop the top num from the stack, do the
                    corresponding multiplication or division and add that num to the stack again
                */
                if(sign == '+')
                    stack.push(num);

                else if(sign == '-')
                    stack.push(-num);

                else if(sign == '*')
                    stack.push(stack.pop() * num);

                else if(sign == '/')
                    stack.push(stack.pop() / num);

                // Finally change the sign to the sign at the current index and reset the num to 0
                sign = c;
                num = 0;
            }
        }

        // Compute the addition and subtraction based on the nums added to the stack
        int ans = 0;
        for(int number : stack) {
            ans += number;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+5 / 2  "));
    }
}
