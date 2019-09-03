package com.leetcode.graphs;

public class FindTwoJudge {
    /**
     *
     * Have 2 arrays one for who trusts who and other for the trusted people.
     *
     * Iterate through the input trust 2D array and populate the trust and trusted arrays.
     *
     * The [0]th element of the item array is the person who trusts the [1]th person. So we increment
     * corresponding to that number
     *
     * Finally, the person who trusts no one but being trusted by everyone else (N - 1) - Meaning, everyone else other
     * than himself will be the judge. So return that as the res.
     */
    public int findJudge1(int N, int[][] trust) {
        int[] trustArr = new int[N + 1];
        int[] trustedArr = new int[N + 1];

        for(int[] item: trust) {
            trustArr[item[0]]++;
            trustedArr[item[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            if(trustArr[i] == 0 && trustedArr[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Intuition:
     *      Consider trust as a graph, all the pairs are directed edges. The point with in-degree - out-degree = N - 1
     *      become the judge.
     *
     * Explanation:
     *      Have 1 array that combines both - who trusts who and the trusted person
     *
     *      Iterate through the input trust 2D array and populate our array
     *
     *      The [0]th element of the item array is the person who trusts the [1]th person. So we decrement the first
     *      index, [0]th person and increment second index [1]th person as he is the person who is trusted.
     *
     *      Finally, the person who is trusted by everyone but himself (N - 1) will be the judge So return that
     *      as the res we are looking for.
     *
     */
    public int findJudge(int N, int[][] trust) {
        int[] trusted = new int[N + 1];

        // Take each pair of the 2D array and populated the trust and trusted people
        for(int[] pair : trust) {
            trusted[pair[0]]--;
            trusted[pair[1]]++;
        }

        for(int i = 1; i <= N; i++) {
            if(trusted[i] == N - 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTwoJudge obj = new FindTwoJudge();
        System.out.println(obj.findJudge(4, new int[][]{{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        //System.out.println(obj.findJudge(4, new int[][]{{1, 3}, {2, 3}, {3, -1}}));
    }
}
