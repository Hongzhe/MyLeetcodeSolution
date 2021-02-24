package string;

import java.util.Locale;
import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 *
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 * Example 1:
 *
 * Input: "()"
 * Output: 1
 * Example 2:
 *
 * Input: "(())"
 * Output: 2
 * Example 3:
 *
 * Input: "()()"
 * Output: 2
 * Example 4:
 *
 * Input: "(()(()))"
 * Output: 6
 *
 *
 * Note:
 *
 * S is a balanced parentheses string, containing only ( and ).
 * 2 <= S.length <= 50
 */
public class ScoreOfParentheses {

    /**
     * keep track the sum
     * using (()(())) as example:
     *
     * [0] (
     * [0, 0] ((
     * [0] (()         cur = 1;
     * [0,1] (()(      cur = 0;
     * [0,1,0] (()((
     * [0,1] (()(()    cur = 0 + 1;
     * [0] (()(())     cur = 1 + 2 * 1;
     * [] (()(()))     cur = 0 + 6
     *
     * @param S
     * @return
     */
    public int scoreOfParentheses(String S) {
        int cur = 0;
        Stack<Integer> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }


    public static void main(String[] args) {
        ScoreOfParentheses target = new ScoreOfParentheses();
        System.out.println(target.scoreOfParentheses("()") == 1);
        System.out.println(target.scoreOfParentheses("()()") == 2);
        System.out.println(target.scoreOfParentheses("(())") == 2);
        System.out.println(target.scoreOfParentheses("(()(()))") == 6);
        System.out.println(target.scoreOfParentheses("(()(()))()") == 7);
    }
}
