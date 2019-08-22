package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-invalid-parentheses/
 *
 * Time and space yet to research
 */
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        removeHelper(s, res, 0, 0, '(', ')');
        return res;
    }

    public void removeHelper(String s, List<String> res, int iStart, int jStart, char openParen, char closedParen) {
        int openParenCount = 0, closedParenCount = 0;
        // Count the number of openParen and closedParen in the given string to compute if the closedParen is > openParen
        for (int i = iStart; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == openParen)
                openParenCount++;
            if (c == closedParen)
                closedParenCount++;

            // If the closedParenCount > than openParenCount, then we inspect the string from the jStart's position
            if (closedParenCount > openParenCount) { // We have an extra closed paren we need to remove
                for (int j = jStart; j <= i; j++) // Try removing one at each position, skipping duplicates
                    /*
                        If the current char at j is a closedParen
                        and j is the start index or the previous character is not a closedParen
                     */
                    if (s.charAt(j) == closedParen && (j == jStart || s.charAt(j - 1) != closedParen))
                        // Recursion: iStart = i since we now have valid # closed parenthesis thru i. jStart = j prevents duplicates
                        removeHelper(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, openParen, closedParen);
                return; // Stop here. The recursive calls handle the rest of the string.
            }
        }
        // No invalid closed parenthesis detected. Now check opposite direction, or reverse back to original direction.
        String reversed = new StringBuilder(s).reverse().toString();
        if (openParen == '(')
            // Reset the iStart and jStart to 0 cause we have to inspect the string as a fresh start
            removeHelper(reversed, res, 0, 0, ')','(');
        else
            res.add(reversed);
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        System.out.println(obj.removeInvalidParentheses("(a)())()"));
    }
}
