package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman numerals are represented by different symbols.
 * For example. 2 is written as II; 12 is written as XII, which simply X + II
 * The number 27 is written as XXVII, which is X + X + v+II
 Roman numerals are usually written largest to smallest from left to right. However,
 the numeral for four is not IIII. Instead, the number four is written as IV.
 Because the one is before the five we subtract it making four.
 The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

 I can be placed before V (5) and X (10) to make 4 and 9.
 X can be placed before L (50) and C (100) to make 40 and 90.
 C can be placed before D (500) and M (1000) to make 400 and 900.
 Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Example 2:
 *
 * Input: s = "IV"
 * Output: 4
 * Example 3:
 *
 * Input: s = "IX"
 * Output: 9
 * Example 4:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int prev = toInt(chars[0]);
        res += prev;
        for (int i = 1; i < chars.length; i++) {
            int n = toInt(chars[i]);
            if (n > prev) {
                res -= prev;
                res += (n - prev);
            } else {
                res += n;
            }
            prev = n;
        }
        return res;
    }

    private Integer toInt(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        RomanToInteger target = new RomanToInteger();
        System.out.println(target.romanToInt("II") == 2);
        System.out.println(target.romanToInt("IV") == 4);
        System.out.println(target.romanToInt("MCMXCIV") == 1994);
        System.out.println(target.romanToInt("LVIII") == 58);
    }
}
