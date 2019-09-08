package com.leetcode.string;

public class ValidParenthesisString {
    /**
     *
     * Intuition:
     *      Greedy approach - https://leetcode.com/problems/valid-parenthesis-string/solution/
     *
     * Algorithm:
     *      Let open, closed respectively will be the smallest and largest possible number of open left brackets after
     *      processing the current character in the string.
     *
     *      If we encounter a left bracket (c == '('), then open++, otherwise we could write a right bracket, so open--.
     *      If we encounter a right bracket (c == ')'), then closed--, otherwise we must write a right bracket,
     *      so closed++. If closed < 0, then the current prefix can't be made valid no matter what our other choices are.
     *
     *      Also, we can never have less than 0 open left brackets. At the end, we should check that we can have exactly
     *      0 open left brackets.
     *
     *  Time  : O(N), one pass.
     *  Space : O(1), constant space. We only use two pointers
     */
    public boolean checkValidString(String s) {
        /*
            lo, hi respectively will be the smallest and largest possible number of open left brackets after processing
            the current character in the string.
         */
        int lo = 0;
        int hi = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                lo++; // we found an open, so increment lo
            } else {
                lo--; // not an open, so decrement lo
            }

            if(c == ')') { // we found a closed, so decrement hi. This could mean we found a pair of open and closed,
                hi--;      // or closed < 0 which shouldn't happen, so break out of the loop in the next step
            } else {
                hi++;      // not a closed, so increment hi, meaning it can be an open (could be a '*' that could also be an empty string)
            }

            /*
                Left parenthesis '(' must go before the corresponding right parenthesis ')'

                hi can't be less than 0, meaning, the current prefix can't be made valid no matter what our
                other choices are. So break out of the loop
             */
            if(hi < 0)
                return false;

            // We can never have less than 0 open left brackets. So if lo is negative, we reset it to 0
            lo = Math.max(lo, 0);
        }
        return lo == 0; // At the end, we should check that we can have exactly 0 open left brackets.
    }

    public static void main(String[] args) {
        ValidParenthesisString obj = new ValidParenthesisString();
        //System.out.println(obj.checkValidString("((*)"));
        System.out.println(obj.checkValidString("(*)"));
        //System.out.println(obj.checkValidString(")**))"));
    }
}
