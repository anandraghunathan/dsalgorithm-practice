package com.leetcode.heap;

import java.util.PriorityQueue;

/**
 * Solved on Sep 20 2019
 *
 * https://leetcode.com/problems/k-closest-points-to-origin
 *
 * TODO - Quick select approach
 */
public class KthClosestPointsToOrigin {
    /**
        Explanation for the PQ comparator:

             The pq will take an 1-d array as an element. In this 1-d array, the first element p[0] is
             x coordinate and the second element p[1] is y coordinate. In order to construct a max-heap,
             we should construct the lambda expression in this formatter: (a, b)->b-a. Thus, the expression
             p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1] means the difference between the
             square of the distance of first and second point from the origin.

             For example, we have two points p1(x, y) and p2(x, y), if the expression,
             (p2.x* p2.x + p2.y* p2.y) - (p1.x* p1.x + p1.y* p1.y) > 0, meaning the the distance second point
             from the origin is greater than the first one.

        Another explanation:

             It's part of our comparison of the Euclidean distance between two points, p1 and p2. Let's instead
             call the two points A and B. We then get:

                Ax = p[0][0]
                Ay = p[0][1]
                Bx = p[1][0]
                By = p[1][1]

             When we're comparing the Euclidean distance we want to compare (Ax2 + Ay2) with (Bx2 + By2).
             In Java we compare these two by subtracting one from the other. This gives us the formula:

                 (Ax2 + Ay2) - (Bx2 + By2)

             We can then remove the parentheses, which changes the expression to:

                Ax2 + Ay2 - Bx2 - By2

             And this is where the subtraction, rather than addition, comes from. It's really just the same as
             if we would have written:

                private int compare(int[] p1, int[] p2) {
                    return (p1[0] * p1[0] + p1[1] * p1[1]) - (p2[0] * p2[0] + p2[1] * p2[1]);
                }

        Time  : O(N(log K))
                    This is due the fact that the PriorityQueue is implemented as a Binary Heap, which in fact is
                    nothing more then complete binary tree. So both inserting and removing the values through offer()
                    and poll() methods have O(log K) complexity and altogether since you doing this operation N times
                    the total complexity is O(N log K)

        Space : O(K), since we will store K points into the res array
     */
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]));
        for(int[] point : points) {

            pq.offer(point); // Add each points into the maxHeap, bigger numbers on top

            // Check the pq's size, if its greater than K, remove the largest points, cause we have to find the closest points (smaller distance from the origin)
            if(pq.size() > K)
                pq.poll();
        }
        // Populate the res 2D array to hold the Kth closest points to the origin (0, 0)
        int[][] res = new int[K][];
        while(K-- > 0) {// loop till there we find the closest points from the given K
            res[K] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        KthClosestPointsToOrigin obj = new KthClosestPointsToOrigin();
        System.out.print("[");
        for(int[] r : obj.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2)) {
            System.out.print("[");
            int resCount = r.length;
            for(int e : r) {
                System.out.print(e);
                System.out.print(resCount-- > 1 ? ", " : "");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}
