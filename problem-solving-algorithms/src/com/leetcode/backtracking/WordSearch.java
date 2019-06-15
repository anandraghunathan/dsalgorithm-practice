package com.leetcode.backtracking;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (exist(board, i, j, w, 0))
                    return true;
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, int i, int j, char[] word, int index) {
        if (index == word.length)
            return true;
        if (i<0 || j<0 || i == board.length || j == board[i].length)
            return false;
        if (board[i][j] != word[index])
            return false;
        //board[i][j] ^= 256;
        boolean exist = exist(board, i, j+1, word, index+1)
                || exist(board, i, j-1, word, index+1)
                || exist(board, i+1, j, word, index+1)
                || exist(board, i-1, j, word, index+1);
        //board[i][j] ^= 256;
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][] {
                                                {'a'}
                                              }, "aaa")
                          );
    }
}
