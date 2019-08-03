package com.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 *  https://leetcode.com/problems/queue-reconstruction-by-height/
 *
 *  Time  : O(N ^ 2) - O(N log N) for sort, and O(N) for inserting into queue
 *  Space : O(N) to keep the output
 */
public class QueueReconstructionByHeight {
    /**
        Three steps-

             1. Sort people:
                I. In the descending order by height.
                II. Among the guys of the same height, in the ascending order by k-values.

             2. Take guys one by one, and place them in the output array at the indexes equal to their k-values.

             3. Return output array.
     */
    public static int[][] reconstructQueue(int[][] people) {

        /** Step 1 */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] obj1, int[] obj2) {
                // if heights of the two objects are the same, compare their k-values and arrange ascending based on k-values
                return obj1[0] == obj2[0] ? obj1[1] - obj2[1] : obj2[0] - obj1[0];
            }
        });

        /** Step 2 */
        List<int[]> output = new LinkedList();
        for(int[] person : people) {
            output.add(person[1], person);
        }

        /** Step 3 */
        return output.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
            {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        for(int[] array : reconstructQueue(input)) {
            System.out.print("[");
            for(int n : array) {
                System.out.print(" " + n + " ");
            }
            System.out.println(']');
        }
    }
}
