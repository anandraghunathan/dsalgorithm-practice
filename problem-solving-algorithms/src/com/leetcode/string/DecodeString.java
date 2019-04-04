package com.leetcode.string;

import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if ( ch == '[') {
                intStack.push(k);
                strStack.push(cur);
                cur = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder tmp = cur;
                cur = strStack.pop();
                for (k = intStack.pop(); k > 0; --k)
                    cur.append(tmp);
            } else
                cur.append(ch);
        }
        return cur.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("1[abc]3[cd]ef"));
    }
}
