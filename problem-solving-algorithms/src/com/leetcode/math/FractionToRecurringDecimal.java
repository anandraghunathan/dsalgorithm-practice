package com.leetcode.math;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal
 *
 * Time  : O(denominator), cause the mod must be less than denominator. so you can run from 1 to mod times
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        // "+" or "-". ^ is XOR. Meaning, the result will be negative only when one of the numbers (numerator, denominator) is negative.
        if((numerator > 0) ^ (denominator > 0))
            res.append("-");
        else
            res.append(""); // this is redundant but added for better readability and understanding

        // long type because we have to handle overflow like −2147483648/-1
        // Handle division for result without decimal
        // long explicit type casting is required to handle the overflow
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);

        // integral part to handle division for result without decimal. To handle fractional numbers BEFORE '.'
        res.append(num / den);
        num %= den;
        if (num == 0) {
            return res.toString();
        }

        // fractional part to handle division for result with decimal. To handle fractional numbers AFTER '.'
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }
            else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        FractionToRecurringDecimal obj = new FractionToRecurringDecimal();
        System.out.println(obj.fractionToDecimal(-1, -3));
    }
}
