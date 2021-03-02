package divideAndConquer;

/**
 * Given a string s and an integer k, return the length of the longest substring of s such that
 * the frequency of each character in this substring is greater than or equal to k.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaabb", k = 3
 * Output: 3
 * Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
 * Example 2:
 *
 * Input: s = "ababbc", k = 2
 * Output: 5
 * Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of only lowercase English letters.
 * 1 <= k <= 105
 */
public class LongestSubstringWithAtLeastKRepeatingcharacter {

    public int longestSubstring(String s, int k) {
        return func(s, 0, s.length(), k);
    }

    public int func(String s, int left, int right, int k) {
        if (right < k) return 0;
        int[] frequency = new int[26];
        for (int i = left; i < right; i++) {
            frequency[s.charAt(i) - 'a'] += 1;
        }
        for (int split = left; split < right; split++) {
            if (frequency[s.charAt(split) - 'a'] >= k) continue;
            int nextSplit = split + 1;
            while (nextSplit < right && frequency[s.charAt(nextSplit) - 'a'] < k) {
                nextSplit++;
            }
            return Math.max(func(s, left, split, k), func(s, nextSplit, right, k));
        }
        return right - left;
    }

    public int longestSubstring2(String s, int k) {
        return helper(s, k, 0, s.length());
    }

    private int helper(String s, int k, int start, int end) {
        if (end < k) return 0;
        int[] countMap = countMap(s, start, end);
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] <k)
                midNext++;
            return Math.max(helper(s, k, start, mid), helper(s, k, midNext, end));
        }
        return end - start;
    }

    private int[] countMap(String s, int start, int end) {
        int[] countMap = new int[26];
        char[] chars = s.toCharArray();
        for (int i = start; i < end; i++) {
            countMap[chars[i] - 'a']++;
        }
        return countMap;
    }

    public static void main(String[] args) {
        LongestSubstringWithAtLeastKRepeatingcharacter target = new LongestSubstringWithAtLeastKRepeatingcharacter();
        //System.out.println(target.longestSubstring("ababbc", 2));
        //System.out.println(target.longestSubstring("aaabb", 3));
        System.out.println(target.longestSubstring("bbaaacbd", 3));
    }
}
