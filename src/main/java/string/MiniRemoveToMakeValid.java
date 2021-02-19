package string;

import java.util.Stack;

/**
 * Given a string s of '(' , ')' and lowercase English characters.
 *
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 *
 *
 * Example 1:
 *
 * Input: s = "lee(t(c)o)de)"  (()) )
 * Output: "lee(t(c)o)de"
 * Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
 * Example 2:
 *
 * Input: s = "a)b(c)d"  )()
 * Output: "ab(c)d"
 * Example 3:
 *
 * Input: s = "))(("  2) 2(
 * Output: ""
 * Explanation: An empty string is also valid.
 * Example 4:
 *
 * Input: s = "(a(b(c)d)"  3( 2)
 * Output: "a(b(c)d)"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class MiniRemoveToMakeValid {

    //如果 遇到close没有open 直接去掉close
    //如果 少n个close，去掉n个open
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> open = new Stack<>();
        Stack<Integer> close = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                open.push(i);
            } else if (ch == ')') {
                if (open.size() == close.size()) {
                    chars[i] = '0';
                } else {
                    close.push(i);
                }
            }
        }
        if (open.size() > close.size()) {
            while (open.size() > close.size()) {
                chars[open.pop()] = '0';
            }
        } else if (open.size() < close.size()) {
            while (close.size() > open.size()) {
                chars[close.pop()] = '0';
            }
        }
        return buildString(chars);
    }

    private String buildString(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch !='0') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MiniRemoveToMakeValid target = new MiniRemoveToMakeValid();
        String s = "lee(t(c)o)de)";
        System.out.println(target.minRemoveToMakeValid(s));
        s = "))((";
        System.out.println(target.minRemoveToMakeValid(s));
        s = "(a(b(c)d)";
        System.out.println(target.minRemoveToMakeValid(s));
        s = "a)b(c)d";
        System.out.println(target.minRemoveToMakeValid(s));
        s = "())()((("; //"()()"
        System.out.println(target.minRemoveToMakeValid(s));
    }
}
