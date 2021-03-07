package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ret);
        return ret;
    }

    private void helper(String s, int left, List<String> current, List<List<String>> ret) {
        if (left >= s.length()) ret.add(current);
        for (int i = left; i < s.length(); i++) {
            if (isPalindrome(s, left, i)) {
                current.add(s.substring(left, i+1));
                helper(s, left+1, current, ret);
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
