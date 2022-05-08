package leetcode;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by cshuo on 2021/7/20
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 *
 *
 * Example 1:
 *
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 *
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 *
 * Input: s = ""
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 3 * 104
 * s[i] is '(', or ')'.
 *
 */
public class LC32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("())(())"));
    }

    public static int longestValidParentheses(String s) {
        if (s.isEmpty()) return 0;
        int max = 0;
        Stack<Integer> q = new Stack<>();
        q.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (q.peek() != -1 && s.charAt(q.peek()) == '(') {
                    q.pop();
                    max = Math.max(max, i - q.peek());
                } else {
                    q.push(i);
                }
            } else {
                q.push(i);
            }
        }
        return max;
    }
}
