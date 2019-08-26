package com.leetcode.backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exist(board, i, j, w, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int i, int j, char[] word, int matchCount) {
        if (matchCount == word.length)
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length)
            return false;

        if (board[i][j] != word[matchCount])
            return false;

        // To check if the char in the current cell is a reuse
        board[i][j] ^= 256;
        boolean exist = exist(board, i, j+1, word, matchCount+1)
                || exist(board, i, j-1, word, matchCount+1)
                || exist(board, i+1, j, word, matchCount+1)
                || exist(board, i-1, j, word, matchCount+1);
        board[i][j] ^= 256;

        return exist;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][] {
                                                {'a', 'a', 'e'},
                                                {'k', 'h', 'i'},
                                                {'d', 'f', 'g'},
                                              }, "aahigfdkaa")
                          );
    }
}
