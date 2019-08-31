package com.leetcode.heap;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    /**
     *
     *  Intuition - Min Heap
     *    1. Build a minHeap of elements from the first row.
     *    2. Do the following operations k-1 times:
     *         Every time when you poll out the root(Top Element in Heap), you need to know the row number and
     *         column number of that element(so we can create a tuple class here), replace that root with the next
     *         element from the same column.
     *
     *   Time   : O(K log N), where k is the given smallest element to be found and N denotes each row in the matrix
     *
     *            One optimization that we can do is, we don't need to run the first loop 'n' times. If k < n we can
     *            run the first loop only 'k' times.
     *
     *            There will be n elements in the PriorityQueue, which is the column size since we're putting the first
     *            row into the PriorityQueue. So poll() and offer() will take logn
     *
     *           So the complexity is = O(min(n,k) + K log N) = O(K log N)
     *
     *   Space  : O(N), at most we store all the elements of the 2D matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        /*
            Check if the matrix rows is less than the given k, if so, make the number of matrix rows as n, or set k.
            This avoids the running the first loop 'n' times cause given k can be found in the first row or second row,
            so we only iterate till k to find the Kth smallest element
         */
        int n = matrix.length < k ? matrix.length : k;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();

        // Iterate through the column to push vals into the min heap
        for(int j = 0; j <= n - 1; j++) {
            // Push the first row (each column) into the min heap
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        /*
            Iterate through the k - 1 times to find the
            smallest in the matrix, poll the top element in
            the min heap to move ahead one step at a time
            towards the kth element

            After removing the top element, go ahead and add
            the next element immediately below the current
            column if the row is less n - 1.
        */
        for(int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if(t.x == n - 1)
                continue; // We have hit the last row, can go down to add any further
            // Else, add the next row's val below the current val that we polled
            pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
        }
        // Poll the current element in the min heap and return it's val as we've found the Kth smallest number
        return pq.poll().val;
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple (int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo (Tuple that) {
        return this.val - that.val; // Min heap, so numbers stored in the heap in increasing order
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix obj = new KthSmallestInSortedMatrix();
        System.out.println(obj.kthSmallest
                        (new int[][] {
                                        {1, 5, 9},
                                        {10, 11, 13},
                                        {12, 13, 15}
                                     },
                    8));
    }
}


