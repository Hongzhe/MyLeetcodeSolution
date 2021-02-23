package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest sustring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, left = 0, i = 0;
        char[] chars = s.toCharArray();
        Map<Character, Integer> visited = new HashMap<>();
        Integer idx = -1;
        for (; i < chars.length; i++) {
            char ch = chars[i];
            idx = visited.get(ch);
            if (idx != null) {
                max = Math.max(max, i - left);
                left = Math.max(left, idx + 1);
            }
            visited.put(ch, i);
        }
        max = Math.max(max, chars.length - left);
        return max;
    }

    //stored last visited idx in array
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int[] visited = new int[128];
        Arrays.fill(visited, -1);
        int max = 0;
        int left = 0, right =0;
        for (; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (visited[ch] > -1) {
                max = Math.max(max, right - left);
                left = Math.max(visited[ch] + 1, left);
            }
            visited[ch] = right;
        }
        max = Math.max(max, right - left);
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters target = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(target.lengthOfLongestSubstring("pwwkew") == 3);
        System.out.println(target.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(target.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(target.lengthOfLongestSubstring("abcabcd") == 4);
        System.out.println(target.lengthOfLongestSubstring("") == 0);
        System.out.println(target.lengthOfLongestSubstring("abba") == 2);
        System.out.println(target.lengthOfLongestSubstring(" ") == 1);
    }
}
