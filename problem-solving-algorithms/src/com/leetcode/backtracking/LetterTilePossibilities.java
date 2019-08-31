package com.leetcode.backtracking;

/**
 * https://leetcode.com/problems/letter-tile-possibilities/
 *
 * https://leetcode.com/problems/letter-tile-possibilities/discuss/308284/Concise-java-solution
 *
 *  Implementation
 *
 *  1. We don't need to keep track of the sequence. We only need count
 *  2. If we implement the above idea by each level (Count all sequence of length 1, then count all sequence of
 *     length 2, etc), we have to remember previous sequence.
 *  3. So we use recursion instead. Just remember to add the count back (arr[i]++).
 *
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        int[] count = new int[26];
        for (char c : tiles.toCharArray()) count[c - 'A']++;
        return dfs(count);
    }

    private int dfs(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0)
                continue;
            /*
                sum++; means with these current tiles (not necessarily all the tiles given) we already have a
                valid combination.
             */
            sum++;

            // This means we are using the i-th tile ('A'+i) as the current tile because there are still remaining ones.
            arr[i]--;
            /*
                This means if we still want to add more tiles to the existing combination, we simply do
                recursion with the tiles left;
             */
            sum += dfs(arr);
            /*
                arr[i]++; is backtracking because we have finished exploring the possibilities of using the i-th tile
                and need to restore it and continue to explore other possibilities.
             */
            arr[i]++;
        }
        return sum;
    }

    public static void main(String[] args) {
        LetterTilePossibilities obj = new LetterTilePossibilities();
        System.out.println(obj.numTilePossibilities("AAB"));
    }
}
