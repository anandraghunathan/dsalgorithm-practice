package com.leetcode.hard;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * Time  : O(m * n)
 * Space : O(m * n)
 *
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        char[] text = s.toCharArray();
        char[] pattern = p.toCharArray();

        /*
            Replace multiple * with one *, cause 1 or more '*' all means the same, cause * already
            denotes zero or more occurrences of any sequence of characters (including an empty sequence)

            Ex: a**b***c --> a*b*c,
                ***ab --> *ab
        */
        int writeIndex = 0;
        boolean isFirst = true;
        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        /*
            The writeIndex value here would have removed all excess '*' and would have only retained only one for each sequence
            Ex: If pattern = 'x*****z', after the last for loop's execution, the writeIndex will be 3, with the pattern being "x*z"
        */

        boolean match[][] = new boolean[text.length + 1][writeIndex + 1];

        /*
            1. To handle when the first character of the pattern is a '*'
            2. We check for writeIndex > 0 because the pattern can be a null, yet checking for pattern[0] == '*'
                will throw ArrayIndexOutOfBoundsException
        */
        if (writeIndex > 0 && pattern[0] == '*') {
            match[0][1] = true;
        }

        // An empty string/text, and an empty pattern is match, so we make match[0][0] as true.
        match[0][0] = true;

        for (int i = 1; i < match.length; i++) {
            for (int j = 1; j < match[0].length; j++) {
                if (pattern[j - 1] == '?' || text[i - 1] == pattern[j - 1]) {
                    /*
                        If the character at string[i-1] is the same as the pattern[j-1], it means excluding both from the comparison, as in
                        match[i - 1][j - 1] will also be true cause the current match is just an extension of the old match found diagonally to this
                        current cell value
                    */
                    match[i][j] = match[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    /*
                        If the pattern is a '*', then there can be two cases,
                            1. Either, we EXCLUDE the '*' in our comparision, meaning zero or empty occurrence of any character sequence.
                                In this case, it means, we are seeing the cell to the left of the current pattern comparison.
                                Ex: text="xby", pattern="x?y*", if we exclude '*' for the comparison, we will compare text="xby"
                                with pattern="x?y", which will match. This cell is nothing but the left cell to the current one, match[i][j-1]

                            2. Or, we INCLUDE the '*' in our comparison, meaning 1 or more occurrences of the any character sequence.
                                In this case, it means we are seeing the cell to the top of the current text comparison.
                                Ex: text="xbyl", pattern="x?y*", if we include '*' for the comparison, we will compare
                                text="xby" with pattern="x?y", as we can remove '*' from the pattern for 'y' in the text, as '*' indicates
                                1 or more occurence of any sequence of characters , thus we are left with the following text and pattern pair.
                                This is a match. This cell is an extension of top of current one, match[i-1][j]
                    */
                    match[i][j] = match[i - 1][j] || match[i][j - 1];
                }
            }
        }
        return match[text.length][writeIndex];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("acdcb", "a*c?b"));
    }
}
