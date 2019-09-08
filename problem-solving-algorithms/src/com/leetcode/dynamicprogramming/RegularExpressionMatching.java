package com.leetcode.dynamicprogramming;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * https://www.youtube.com/watch?v=l3hda49XcDE&t=84s
 *
 * Time  : O(m * n)
 * Space : O(m * n)
 */
public class RegularExpressionMatching {
    /**
     *
     * Solved using dynamic programming as it involves solving the smaller sub-problems to eventually solve the larger problem
     *
     * s = "xaaby"
     * p = "xa*b.c"
     *
     */
    public static boolean isMatch(String s, String p) {
        // A 2D boolean matrix is initialized to hold the solutions to smaller sub-problems
        boolean match[][] = new boolean[s.length() + 1][p.length() + 1];

        /*
            When the given string is an empty string and the pattern is an empty
            string as well, there is a pattern match for that particular sub-problem
        */
        match[0][0] = true;

        // First lets solve the cases when the pattern is a*, a*b*, a*b*c*
        for(int i = 1; i < match[0].length; i++) {
            if(p.charAt(i - 1) == '*') {
                match[0][i] = match[0][i - 2];
            }
        }

        for(int i = 1; i < match.length; i++) {
            for(int j = 1; j < match[0].length; j++) {
                /*
                    If the character in the string at the previous index matches
                    with the character in the pattern at the same index, then assign
                    the T[i][j] to the T[i-1][j-1]. In other words, assign the diagonal
                    cell value from the bottom-up matrix we built. Also, if the current
                    pattern character is '.', then we do the same thing

                    Intuition:

                    Given a string = "aa", pattern = "a*", when i = 1 and j = 1,
                    here 'a' and 'a' of the 0th index is a match. The 0th index of
                    the string and pattern (i - 1) & (j - 1) will "CONTINUE TO MATCH"
                    because, even when we remove it from the consideration, the empty
                    string and empty pattern is already a match.

                    Therefore, just consider what's there in the diagonal cell of the table
                */
                if(p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    match[i][j] =  match[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    /*
                        When the index (j - 1) of the pattern is a '*', there are two thing
                        that can happen,
                            1. Assign the value in table's cell value in the (j-2) index
                                - (Zero occurrence of the character before '*')

                                Ex: s = "xa", p = "xa*", here zero occurrence of a won't work,
                                cause s = "xa" is not same as p = "x", so we set "false"

                            2. However, if the pattern at (j-2) matches with the string at
                            (i-1) or its '.', assign the cell that's above the (j-1).
                                - (Character before '*' in the pattern is a match with the
                                   character in the string, assign the top cell value in the table)

                                Ex: s = "xa", p = "xa*", here 'a' in string matches with the
                                pattern 'a', so "xa" is part of the regular expression match
                                for the pattern "xa*", therefore, we try s = "x" if its a match
                                with the pattern p = "xa*", which is true (from the above cell in
                                the table match(i - 1)[j]), so we set "true"

                                occurrence of a won't work,
                                cause s = "xa" is not same as p = "x", so we set "false"

                            If both are if and else if are false, we assign false for the
                            particular sub-problem in the next else condition
                    */
                    match[i][j] = match[i][j - 2];
                    if(p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        /*
                            If match[i][j] is already set, the below condition won't change it
                            If its already set to true in match[i][j] = math[i][j-2]; step above,
                            don't change it, just retain the same value for the cell.
                        */
                        match[i][j] = match[i][j] || match[i - 1][j];
                    }

                } else {
                    // if both of the above conditions are false, we assign false to the current cell
                    match[i][j] = false;
                }
            }
        }
        return match[s.length()][p.length()];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "ab*a*c*a"));
    }
}
