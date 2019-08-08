package com.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;

            // create a list of numbers to get indices
            numbers.add(i); // numbers = {1, 2, 3, 4}
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // Cause the index starts with 0, we decrement once
        k--;

        for(int i = 1; i <= n; i++){
            /*

                i = 1

                First find the index and then using the index, compute the k to find the next permutation number.
                So, if k is 14, k-- would make it 13, so we need to find the 13th permutation out of the
                24 permutations (4 * 3 * 2 * 1).

                1. To find index, 13/factorial[4 - 1], 13/6 = 2. Meaning, 2nd index of {1, 2, 3, 4}, which is 3.
                2. So we append 3 in the next step.
                3. We remove the 3 added in in the last step
                4. Recompute the k, cause our k is no longer the 14th, because in the previous step, we've already
                eliminated the 12 4-number permutations starting with 1 and 2. So you subtract 12 from k -> 13 - 12, gives 1.

                Programmatically that would be - k = k - (index from previous) * (n - 1)! = k - 2*(n-1)! = 13 - 2*(3)! = 1


                i = 2

                In this second step, permutations of 2 numbers has only 2 possibilities, meaning each of the three
                permutations listed above a has two possibilities, giving a total of 6. We're looking for the first one,
                so that would be in the 1 + (permutations of 2, 4) subset.

                Meaning: index to get number from is k / (n - 2)! = 1 / (4-2)! = 1 / 2! = 0 from {1, 2, 4}, index 0 is 1
                so the numbers we have so far is 3, 1...

                Recompute k,
                k = k - (index from previous) * (n - 2)! = k - 0 * (n - 2)! = 1 - 0 = 1;

                i = 3

                {2, 4}

                third number's index = k / (n - 3)! = 1 / (4-3)! = 1/ 1! = 1... from {2, 4}, index 1 has 4

                Third number is 4

                Recompute k,
                k = k - (index from previous) * (n - 3)! = k - 1 * (4 - 3)! = 1 - 1 = 0;

                i = 4

                {2}

                third number's index = k / (n - 4)! = 0 / (4-4)! = 0/ 1 = 0... from {2}, index 0 has 2

                Fourth number is 2


                Giving us 3142. If you manually list out the permutations using DFS method, it would be 3142. Done!

                It really was all about pattern finding.

             */
            int index = k/factorial[n-i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 14));
    }
}
