package com.leetcode.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    static HashMap<Character, Character> paren = new HashMap<>();
    static {
        paren.put(')', '(');
        paren.put('}', '{');
        paren.put(']', '[');
    }

    /** Best approach */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c : s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }

        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()) {
            if(paren.containsKey(c)) {
                char popped = stack.empty() ? '#' : stack.pop();

                if(popped != paren.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        //System.out.println(isValid2("{[]}"));
    }
}
