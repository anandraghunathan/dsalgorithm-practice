package com.leetcode.string;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<StringBuilder> strStack = new Stack();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for(Character ch : s.toCharArray()) {
            // Check if the character is a number
            if(Character.isDigit(ch)) {
                /* If its digit, convert from the character set into an Integer
                 the * 10 is when the given number is more than 1 digit (10, 11, etc) */
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                /* Push the current k into the integer stack and the current SB into
                the String Stack and reset the values to its original state. */
                intStack.push(k);
                strStack.push(cur);
                k = 0;
                cur = new StringBuilder();
            } else if (ch == ']') {
                /* Retrieve the current string constructed in the 'else' condition below
                    into a temp variable, obtain the string present inside the String
                    Stack, iterate through the value of the integer obtained using
                    the integer stack value */
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for(k = intStack.pop(); k > 0; k--) {
                    cur.append(tmp);
                }
            } else {
                // Append the current character into the String Builder
                cur.append(ch);
            }
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("12[abc]3[cd]ef"));
    }
}
