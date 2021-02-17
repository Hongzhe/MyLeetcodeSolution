package backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase
 * to create another string.
 * Return a list to all possible we could create. You can return the output in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * Example 2:
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4","3Z4"]
 * Example 3:
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 * Example 4:
 * <p>
 * Input: S = "0"
 * Output: ["0"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * S will be a string with length between 1 and 12.
 * S will consist only of letters or digits.
 */
public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new LinkedList<>();
        helper(S.toCharArray(), 0, list);
        return list;
    }

    private void helper(char[] chars, int idx, List<String> list) {
        if (idx == chars.length) {
            list.add(new String(chars));
            return;
        }
        char ch = chars[idx];
        if (Character.isDigit(ch)) {
            helper(chars, idx+1, list);
            return;
        }
        chars[idx] = Character.toLowerCase(ch);
        helper(chars, idx+1, list);
        chars[idx] = Character.toUpperCase(ch);
        helper(chars, idx+1, list);
    }

    public static void main(String[] args) {
        String s = "abc";
        LetterCasePermutation target = new LetterCasePermutation();
        List<String> list = target.letterCasePermutation(s);
        list.forEach(System.out::println);
    }
}
