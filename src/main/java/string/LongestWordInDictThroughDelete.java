package string;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string and a string dictionary,
 * find the longest string in the dictionary that can be formed by deleting some characters of the given string.
 * If there are more than one possible results, return the longest word with the smallest lexicographical order.
 * If there is no possible result, return the empty string.
 *
 * Example 1:
 *
 * Input:
 * s = "abpcplea", d = ["ale","apple","monkey","plea"]
 *
 * Output:
 * "apple"
 * Example 2:
 *
 * Input:
 * s = "abpcplea", d = ["a","b","c"]
 *
 * Output:
 * "a"
 * Note:
 *
 * All the strings in the input will only contain lower-case letters.
 * The size of the dictionary won't exceed 1,000.
 * The length of all the strings in the input won't exceed 1,000.
 */
public class LongestWordInDictThroughDelete {

    public String findLongestWord(String s, List<String> d) {
        char[] chs = s.toCharArray();
        String res = "";
        for (String item : d) {
            char[] chars = item.toCharArray();
            if (chars.length < res.length()) continue;
            int i = 0, j = 0;
            for (; i < chs.length && j < chars.length; i++) {
                if (chs[i] == chars[j]) {
                    j++;
                }
            }
            if (j == chars.length) {
                if (res.length() == chars.length) {
                    res = res.compareTo(item) > 0 ? item :res;
                } else if (res.length() < chars.length) {
                    res = item;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestWordInDictThroughDelete target = new LongestWordInDictThroughDelete();
        System.out.println(target.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
        System.out.println(target.findLongestWord("abpcplea", Arrays.asList("a","b","c")));
        System.out.println(target.findLongestWord("bab", Arrays.asList("ba","ab","a","b")));
    }
}
