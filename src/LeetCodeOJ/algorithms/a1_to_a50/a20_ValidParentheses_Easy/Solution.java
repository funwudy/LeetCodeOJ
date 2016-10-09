package algorithms.a1_to_a50.a20_ValidParentheses_Easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by 31798 on 2016/10/7.
 */
// #Stack#, #String#
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.addLast(ch);
            } else {
                if (!stack.isEmpty() && stack.peekLast() == correspondingOf(ch)) {
                    stack.pollLast();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char correspondingOf(char ch) {
        switch (ch) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        return ' ';
    }
}