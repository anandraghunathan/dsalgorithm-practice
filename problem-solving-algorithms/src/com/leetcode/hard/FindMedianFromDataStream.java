package com.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * Time  : addNum() is O(log(n)) O(log(n)) with regards to two heaps
 *         findMedian() is a constant operation as we are just peeking the top element in the PriorityQueue
 *
 * Space : O(n), worst case
 *
 *        Median is the middle value in an ordered integer list, so median will halve the list into a bigger half
 *        and a smaller half.
 *
 *        If the size of the list is even, median is the mean of the two middle value, i.e., the mean of the minimum of
 *        the bigger half and the maximum of the smaller half.
 *
 *        If the size of the list is odd, median is the maximum of the smaller half (if we always make smaller half
 *        larger (with more number of elements)) or the minimum of the bigger half (if we always make bigger half larger
 *        (with more number of elements)).
 */
public class FindMedianFromDataStream {
    /**
         We keep track of bigger and smaller half of the stream using priority queues. To get a median, we peek at
         minHeap if it has more elements than maxHeap (this means we had an odd number of elements so far).

         Otherwise, meaning we had even number of elements, we peek at both queues, sum both numbers and divide
         that by 2.0 - this is our result.

        In this implementation (implementation can also be made in a way that maxHeap holds more number of elements too),
            bigger half - minHeap will (at max) hold more number of elements (1 element more if array is odd length)
                          or equal to maxHeap
            smaller half - maxHeap will hold equal or one less element than minHeap. However, maxHeap will hold
                           smallest number added

        For each addition, two heaps should satisfy the below two conditions:
            #1 - size of maxHeap = (size of minHeap + 1) (OR) size of maxHeap = size of minHeap
            #2 - max of maxHeap <= min of minHeap

        This way, we only need to peek the two heaps' top element to calculate the median.
     */

    /*
        minHeap holds the larger elements of the stream with the ability to provide the least
        element in it in O(1)
    */
    private PriorityQueue<Integer> minHeap;
    /*
        maxHeap holds the smaller elements of the stream with the ability to provide the largest
        element in it in O(1)
    */
    private PriorityQueue<Integer> maxHeap;

    private boolean even;


    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        minHeap = new PriorityQueue();
        maxHeap = new PriorityQueue(Collections.reverseOrder());
        even = true;
    }

    public void addNum(int num) {
        if(even) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        /*
            As minHeap should have equal or 1 more element than maxHeap, we poll from maxHeap
            to add the element into the minHeap
        */
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        even = !even;
    }

    public double findMedian() {
        // Divided by 2.0 to return the double value as returning an integer will truncate the decimal
        return (maxHeap.size() == minHeap.size()) ? (maxHeap.peek() + minHeap.peek()) / 2.0
                : minHeap.peek();
    }

    public static void main(String[] args) {
        FindMedianFromDataStream obj = new FindMedianFromDataStream();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        //obj.addNum(4);
        System.out.println(obj.findMedian());
    }
}
