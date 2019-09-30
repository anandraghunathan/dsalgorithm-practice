package com.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 *
 * https://stackoverflow.com/questions/31120402/complexity-when-generating-all-combinations
 *
 * Time  : O(n^min{k,n-k}) or n!/(n-k)!. For example, if n = 4, k = 4, then there's 24 combinations. But if n = 4, k = 0,
 *         there's 0 combinations. If n = 4, k = 1, there's 4 combinations.
 * Space : O(K)
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineHelper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void combineHelper(int n, int k, int start, List<Integer> subList, List<List<Integer>> res) {
        if(k == 0) {
            res.add(new ArrayList<>(subList));
            return;
        } else {
            /**
             * i <= n will work fine. But, i <= n - k + 1 will improve the performance greatly.
             *
             * This is because we should not continue exploring (recursion) when we know that there won't be enough
             * numbers left until n to fill the needed k slots. If n = 10, k = 5, and we're in the outermost level of
             * recursion, you choose only i = 1...6, because if we pick i=7 and go into backTracking() we will only have
             * 8,9,10 to pick from, so at most we will get [7,8,9,10]... but we need 5 elements!
             *
             * Take combine(4, 2) as an example, the program does not need to try the combination starting with 4,
             * because it has been covered by those starting with 1, 2 and 3. The same applies for each sub-problem in
             * the recursions.
             */
            for(int i = start; i <= n-k + 1; i++) {
                subList.add(i);
                combineHelper(n, k - 1, i + 1, subList, res);
                subList.remove(subList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println("[");
        System.out.print("    ");
        List<List<Integer>> res = obj.combine(4, 2);
        int resCount = res.size();
        for(List<Integer> nums : res) {
            System.out.print("[ ");
            int numsCount = nums.size();
            for(int num : nums) {
                System.out.print(num);
                System.out.print(numsCount-- > 1 ? ", " : "");
            }
            System.out.print(resCount-- > 1 ? "]," : "]");
        }
        System.out.println("");
        System.out.println("]");
    }
}
