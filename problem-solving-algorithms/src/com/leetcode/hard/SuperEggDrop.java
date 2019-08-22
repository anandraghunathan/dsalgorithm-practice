package com.leetcode.hard;

/**
 * Created by Anand Raghunathan on 2019-08-20
 *
 * https://leetcode.com/problems/super-egg-drop/
 *
 * Time  : O(totalFloors * totalEggs) * O(totalFloors) = O(totalFloors ^ 2) * O(totalEggs).
 *         In total, there are totalFloors times totalEggs sub-problems, and it takes an
 *         totalFloor times to compute each sub-problem. Meaning, we use fraction of the
 *         some total number of floors to compute each sub-problem
 *
 * Space : O(totalFloors * totalEggs), We are going to hold totalFloors times totalEggs sub-problems
 *         in our DP array (cache)
 */
public class SuperEggDrop {

    /**
     * The below solution has turned the problem around from
     * "How many moves do you need to check N floors if you have K eggs"
     * to:
     * "How many floors can you check given M moves available and K eggs".
     *
     * If you can solve this second problem than you can just increase the moves M one by one until you are able to
     * check a number of floors larger or equal to the number N which the problem requires.
     *
     * He then defined
     * dp[M][K] as the maximum number of floors that you can check within M moves given K eggs
     *
     * A move essentially is dropping an egg and it either breaks or doesn't break.
     *
     * Case A: The egg breaks and now you have spent 1 move (M=M-1) and also lost 1 egg (K=K-1). You can still check
     * dp[M-1][K-1] floors, with your remaining eggs and moves.
     *
     * Case B: The egg remains and you only loose one move (M=M-1). You can still check dp[M-1][K] floors.
     *
     * Additionally you just checked a floor by dropping the egg from it.
     *
     * Therefore dp[M][K] = dp[M - 1][k - 1] + dp[M - 1][K] + 1
     *
     * As you can see we can easily calculate how many floors we can check in M moves if we know how many floors we can check in M-1 moves.
     *
     * However we not only have to know how many floors we can can check with one move less, but also how many we can check with one move and one egg less. Therefore we have to calculate how many moves we can check for all number off eggs from 1 to K.
     *
     * An example:
     * N = 6 and K = 2
     * Turn the problem around: How many floors can you check with 2 eggs and M moves:
     *
     * Solve for M=1, K=1,2
     * you can only check 1 floor (since afterwards you have no more moves left)
     *
     * Solve for M=2, K=1
     * Case A: Your egg breaks, you have no more eggs left and can check nothing. dp[M=1,K=0]=0
     * Case B: your egg survives and you can use it to test an additional floor above the floor you just tested. dp[M=1,K=1]=1
     * dp[2][1]=dp[1][0]+dp[1][1]+1=0+1+1=2
     *
     * Solve for M=2, K=2
     * Case A: Your egg breaks: you have 1 move left and 1 egg. Since you know that the floor F where the eggs break is
     * below the floor you just tested you can now check dp[M=1,K=1] floors below you, with only 1 move left you check
     * 1 additional floor below. dp[M=1,K=1]=1
     * Case B: Your eggs survives and you start to search above the current floor. dp[1][2] is still only 1 move and
     * we can check 1 floor. dp[1][2]
     *
     * dp[2][2]=1+1+1=3
     *
     * Solve for M=3, K=1
     * Case A: Your egg breaks and you are out of eggs, no chance to check anything anymore
     * Case B: Your egg survives and you can use it for 2 more moves dp[2][1], which as we established above is enough
     * to check 2 floors.
     *
     * dp[3][1]=0+2+1=3
     *
     * Solve for M=3, K=2
     * Case A: Your egg breaks and you check dp[2][1]=2 additional floors
     * Case B: Your egg survives and you check dp[2][2]=3 additional floors
     * dp[3][2]=2+3+1=6
     *
     * As you can see 3 moves and 2 eggs allows you to check 6 floors. Which answers the original question how many
     * moves you need to check 6 floors given 2 eggs,
     * The answer is 3
     *
     * I hope this helps to make it more clear.
     *
     */
    public int superEggDropBestOptimized(int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        int m = 0;
        while (dp[m][K] < N) {
            m++;
            for (int k = 1; k <= K; ++k)
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1;
        }
        return m;
    }

    /**
     *
     * Solutions tab - Approach 2
     */
    public int superEggDropOptimized(int K, int N) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N+1];

        // Egg == 1, Floor == N. We still make N moves in the worst case
        for (int i = 1; i <= N; i++)
            dp[i] = i;

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N+1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1]))
                    x++;

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
            }

            dp = dp2;
        }

        return dp[N];
    }

    /**
     *
     * Top down, recursive solution
     *
     */
    public int superEggDropRecursive(int K, int N) {
        /**
         * Below two if are base condition checks
         */
        // If total number of eggs is 1, we have to make N moves in the worst case
        if(K == 1) {
            return N;
        }

        // If total number of floors is 0, we have 0 moves to make
        // Similarly, if we have 1 floor, regardless of how many eggs we have, we have to make 1 move
        if(N == 0) {
            return 0;
        } else if(N == 1) {
            return 1;
        }
        int min = 1000;
        for(int i = 1; i <= N; i++) {
            int val = 1 + Math.max(superEggDropRecursive(K - 1, i - 1), superEggDropRecursive(K, N - i));
            if(val < min) {
                min = val;
            }
        }
        return min;
    }

    /**
     *
     * Bottom Up 2D matrix solution
     */
    public int superEggDrop(int totalEggs, int totalFloors) {
        /*
          We do +1 to index off of 1. So that the final answer that
          we want will be at cache[totalEggs][totalFloors]...remember
          we index off of 0 so this is for convenience
          cache[totalEggs][totalFloors] is literally the answer to the
          sub-problem given those literal amounts...'totalEggs' and
          'totalFloors'
        */
        int cache[][] = new int[totalEggs + 1][totalFloors + 1];

        /*
          If we have 0 floors we need 0 trials, no matter the egg amount given
          If we have 1 floor we need 1 trial, no matter the egg amount given
        */
        for (int eggs = 1; eggs <= totalEggs; eggs++) {
            cache[eggs][0] = 0;
            cache[eggs][1] = 1;
        }

        /*
          If we have 1 egg...no matter what floors we get, our approach will
          be to do 'floorAmount' drops...this is because we want to start from
          floor 1, drop...then go to floor 2, drop...and so on until we get to
          in the worst case 'floorAmount'
          Remember, we want to know the minimum amount of drops that will always
          work. So we want to MINIMIZE...to the absolute LEAST...worst...amount
          of drops so that our drop count ALWAYS works
          Any worse then the MINIMIZED WORST will be suboptimal
        */
        for (int floor = 1; floor <= totalFloors; floor++) {
            cache[1][floor] = floor;
        }
        /*
          Solve the rest of the subproblems now that we have base cases defined
          for us
        */
        for (int eggs = 2; eggs <= totalEggs; eggs++) {
            for (int floor = 2; floor <= totalFloors; floor++) {
                /*
                  Initialize the answer to this subproblem to a very large
                  value that will be easily overtaken and provide a hard upper
                  comparison wall
                */
                cache[eggs][floor] = Integer.MAX_VALUE;

                /*
                  We do a theoretical test on every floor from 1 to the 'floor'
                  amount for this sub-problem.
                  At each 'attemptFloor' we express both possibilities described below
                */
                for (int attemptFloor = 1; attemptFloor <= floor; attemptFloor++) {

                    /*
                        We want to know the cost of the 2 outcomes:
                        1.) We drop an egg and it breaks.
                          We move 1 floor down. We have 1 less egg.
                        2.) We drop an egg and it doesn't break.
                          We have this many floors left: the difference between the total floors and our current
                          floor. We have the same number of eggs.
                    */
                    int costOfWorstOutcome = Math.max(cache[eggs - 1][attemptFloor - 1],
                            cache[eggs][floor - attemptFloor]);

                    /*
                        After we get the cost of the WORST outcome we add 1 to that worst outcome
                        to simulate the fact that we are going to do a test from THIS sub-problem.
                        The answer to this problem is 1 PLUS the cost of the WORST SITUATION that
                        happens after our action at this sub-problem.
                    */
                    int accountingForDroppingAtThisSubproblem = 1 + costOfWorstOutcome;

                    /*
                        Did we reach a BETTER (lower) amount of drops that guarantee that we can
                        find the pivotal floor where eggs begin to break?
                    */
                    cache[eggs][floor] = Math.min(cache[eggs][floor], accountingForDroppingAtThisSubproblem);
                }
            }
        }
        /*
          Remember we added +1 so we are indexed off of 1 now. We can reap our answer from
          cache[totalEggs][totalFloors] instead of cache[totalEggs - 1][totalFloors - 1]
        */
        return cache[totalEggs][totalFloors];
    }

    public static void main(String[] args) {
        SuperEggDrop obj = new SuperEggDrop();
        //System.out.println(obj.superEggDrop(2, 6));
        //System.out.println(obj.superEggDropOptimized(2, 6));
        System.out.println(obj.superEggDropBestOptimized(2, 6));
    }
}
