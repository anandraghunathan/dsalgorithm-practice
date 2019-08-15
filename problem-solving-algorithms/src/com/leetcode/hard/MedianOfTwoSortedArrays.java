package com.leetcode.hard;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * https://www.youtube.com/watch?v=LPFhl65R7ww&t=9s
 *
 * Space : O(1), we only need constant memory
 *
 * Time  : O(log(min(m, n)),
 *              (1) The initial searching range is [0, m].
 *
 *              (2) Assume the searching range is [imin, imax], in a searching loop we did :
 *                      i = (imin + imax) / 2; imin = i + 1
 *                   or i = (imin + imax) / 2; imax = i - 1
 *              So, the length of the searching range will be reduced by half after a loop.
 *
 *          Therefore, time complexity of this solution is O(log(m)).
 *
 *          The overall time complexity becomes O(log(min(m, n)) - min(m, n) because based on which array
 *          is the smaller one between the two arrays, the binary search will be performed on that smaller
 *          array so if m <= n, the runtime is O(log(m)). Else, O(log(n)).
 *
 *          Essentially, the runtime is O(log(minimum of the two array lengths))
 *
 */
public class MedianOfTwoSortedArrays {
    /*
        Median of two sorted arrays can be found using binary search, partitioning the two arrays
        into two halves each (4 halves in total), in such a way that
        If the total combined number of elements is,
            1. An odd number, then the left half of the overall combined array will have one
               more element over than the right half - (m + n + 1) / 2 - partitionM, because
               we are doing (m + n + 1) instead of (m + n), that will make the left half
               have one more element than the right half of the partition
            2. An even number, then the left half of the overall combined array will have the
               same number of elements as the right half

        After the partition is done, we do the binary search on the array that is smaller
        of the two
    */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        //if nums1 length is greater than switch them so that nums1 is smaller than nums2.
        if(m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int lo = 0;
        int hi = m;

        /*
            Do a binary search on the smaller array between the two, for example,
            if nums1 is smaller than nums2, the binary search should be performed
            on nums1.
        */
        while(lo <= hi) {

            int partitionM = (lo + hi) / 2;

            /*
                + 1 is make the case common for both odd and even numbers

                By doing (m + n + 1) instead of (m + n) we maintain that left part has more elements in case m+n is odd.
                So when m+n is odd you simply return maxLeftPart.

                You could also change this to (m+n)/2, in which case right part will have more elements if m+n is odd.
                In that case, when length is odd, you need to return minRightPart as the answer.
             */
            int partitionN = (m + n + 1) / 2 - partitionM;

            /*
               Find the max element on the left and min element on the right to find the middle
               number. We find the maxLeft and minRight for nums1 and similarly for nums2

               If the partition yields a value 0, it means there is nothing on the left
               side of the array. So we set the number to the Integer min value (minimum most).
               Else, we will set the number to the current partition value - 1

               nums1[partitionM - 1] & nums2[partitionN - 1] because we will get the max value from
               the left partition (one position left to the current partition value found during binary
               search), so that the other half of the array will start with the minRight,
               minRightM[partitionM] & minRightN[partitionN]
               Ex: nums1 = [0, 1, 2, 3, 4], partitionM is (4 + 0) / 2 = 2.. So,
                        maxLeftM = nums1[partitionM - 1] = 1
                        and minRightM = nums1[partitionM] = 2

                   Similarly,
                   nums2 = [1, 2, 3, 4, 5], partitionN is (4 + 0) / 2 = 2.. So,
                        maxLeftN = nums2[partitionN - 1] = 2
                        and minRightM = nums2[partitionN] = 3

               If the partition yields a value n, it means there is nothing on the right
               side of the array. So we set the number to the Integer max value (maximum most).
               Else, we will set the number to the current partition value

               We explore the maxLeft and the minRight for the two partitions of the array for
               the following reason,

               1. We will compare the maxLeft of the nums1 array if its smaller or equal to the minRight
                  of the nums2 array, similarly we will compare the maxLeft of the nums2 array if
                  its smaller or equal to the minRight of nums1. If both conditions pass, it means we have
                  found our median value.
               2. If the condition doesn't pass, and if the maxLeftM > minRightN, it means we are
                  too far on the right side of the partitionM, so we have move left to make the number
                  maxLeftM smaller than minRightN
               3. Or if the condition didn't pass because of maxLeftN > minRightM, it means we are
                  too far on the left side of the partitionM, so we have to move right to make the number
                  maxLeftN smaller than minRightM

            */
            int maxLeftM = (partitionM == 0) ? Integer.MIN_VALUE : nums1[partitionM - 1];
            int minRightM = (partitionM == m) ? Integer.MAX_VALUE : nums1[partitionM];

            int maxLeftN = (partitionN == 0) ? Integer.MIN_VALUE : nums2[partitionN - 1];
            int minRightN = (partitionN == n) ? Integer.MAX_VALUE : nums2[partitionN];

            if(maxLeftM <= minRightN && maxLeftN <= minRightM) { // We found the right place, median

                // We will check if the total length (combined) of the two array is of length odd or even
                if((m + n) % 2 == 0)
                    /*
                        Even number length so we have to find two numbers (max number from the two left
                        partitions and the min number from the two right paritions) and find the
                        median of those two numbers.

                        DON'T FORGET to convert into double, as these
                        numbers are integers by default
                    */
                    return ((double) (Math.max(maxLeftM, maxLeftN) +
                            Math.min(minRightM, minRightN)) / 2);
                else {
                    /*
                        Odd number length, so its easier to just find the middle number by getting the
                        max number between maxLeft and minRight numbers of the array on which we
                        performed the binary search and return that number as the median

                        DON'T FORGET to convert into double, as these
                        numbers are integers by default
                    */
                    return (double) Math.max(maxLeftM, maxLeftN);
                }
            }
            // We have to still find the median
            else if(maxLeftM > minRightN) { // we have to move left to make maxLeftM smaller than minRightN
                hi = partitionM - 1;
            } else {// we have to move right to make the maxLeftN smaller than minRightM
                lo = partitionM + 1;
            }
        }
        // We can come here only when the input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        int[] m = {0, 1, 2, 3, 4};
        int[] n = {1, 2, 3, 4, 5};

        MedianOfTwoSortedArrays median = new MedianOfTwoSortedArrays();
        System.out.println(median.findMedianSortedArrays(m, n));
    }
}
