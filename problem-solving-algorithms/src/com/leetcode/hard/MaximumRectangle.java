package com.leetcode.hard;

import java.util.Stack;

public class MaximumRectangle {
    public static int maximalRectangle(char[][] matrix) {
        // Declare m and n for the width and length of the matrix and perform empty check,
        // Declare max
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length, maxArea = 0;

        // Declare the rectangle height array to track the height of the rectangle for each row
        int rectangleHeight[] = new int[n + 1];

        for(int i = 0; i < m; i++) {
            // Initialize a new stack to store the indices of the matrix when the value is 1
            Stack<Integer> stack = new Stack();
            stack.push(-1); // Initial value is pushed into the stack
            /*
                Iterate through "j < n + 1", is a fake column, the +1 is to make sure
                stack while loop runs 1 more time with the lowest value 0 as rectangle[j],
                when j has reached its last value. Therefore, the while loop condition will
                pass and start calculating the max

                A check is made (j < n) to populate the rectangleHeight[] though
                to sure j < n to avoid ArrayIndexOutOfBoundsException

                rectangleHeight[] array is of size [n + 1]. That extra 1 is for making sure stack empty loops runs 1 more time.
            */
            for(int j = 0; j < n + 1; j++) {
                if(j < n && matrix[i][j] == '1')
                    rectangleHeight[j] += 1;
                else
                    rectangleHeight[j] = 0;

                while(stack.peek() != -1 && rectangleHeight[j] < rectangleHeight[stack.peek()]) {
                    maxArea = Math.max(maxArea, rectangleHeight[stack.pop()] * (j - (stack.peek() + 1)));
                }
                // Push the current j index
                stack.push(j);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]
//                        {
//                                {'1', '0', '1'},
//                                {'1', '1', '1'},
//                                {'1', '1', '1'},
//                                {'1', '0', '0'}
//                        }
                      {
                              {'1', '0', '0', '0', '0'},
                              {'1', '0', '1', '1', '1'},
                              {'1', '1', '1', '1', '1'},
                              {'1', '0', '0', '0', '0'}
                      }
                ));
    }
}
