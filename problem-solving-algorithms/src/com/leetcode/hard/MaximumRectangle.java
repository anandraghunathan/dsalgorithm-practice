package com.leetcode.hard;

import java.util.Stack;

public class MaximumRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length, max = 0;
        int[] h = new int[n + 1];

         /*
            Input 2D matrix:
                  {'1', '1', '1', '1', '1'},
                  {'1', '1', '1', '1', '1'},
                  {'1', '1', '1', '1', '1'},
                  {'1', '0', '0', '1', '0'}
         */
        for (int i = 0; i < m; i++) {
            Stack<Integer> s = new Stack();
            s.push(-1);
            for (int j = 0; j <= n ;j++) {
                if(j < n && matrix[i][j] == '1')
                    h[j] += 1;
                else h[j] = 0;

                while(s.peek() != -1 && h[j] < h[s.peek()]) {
                    max = Math.max(max, h[s.pop()] * (j - s.peek() - 1));
                }
                s.push(j);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]
                        {
                                {'1', '0', '1'},
                                {'1', '1', '1'},
                                {'1', '1', '1'},
                                {'1', '0', '0'}
                        }
//                      {
//                              {'1', '1', '1', '1', '1'},
//                              {'1', '1', '1', '1', '1'},
//                              {'1', '1', '1', '1', '1'},
//                              {'1', '0', '0', '1', '0'}
//                      }
                ));
    }
}
