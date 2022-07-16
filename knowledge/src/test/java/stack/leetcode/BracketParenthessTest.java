package stack.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class BracketParenthessTest {
    /**
     * leetcode 判断是否为有效的括号
     */
    @Test
    public void testLeetCodeValidParentheses() {
        Assert.assertFalse(isValid(""));
        Assert.assertFalse(isValid("([)]"));
        Assert.assertFalse(isValid("{{{"));
        Assert.assertFalse(isValid("(]"));
        Assert.assertTrue(isValid("()"));
        Assert.assertTrue(isValid("([])"));
        Assert.assertTrue(isValid("()[]{}"));
    }

    private boolean isValid(String s) {
        if (null == s || s.length() == 0 || s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> bracketStack = new Stack<Character>();
        for (char bracket : s.toCharArray()) {
            if (isLeftBracket(bracket)) {
                bracketStack.push(bracket);
                continue;
            }
            if (bracketStack.isEmpty()) {
                return false;
            }
            if (!isParenthess(bracket, bracketStack.peek())) {
                return false;
            }
            bracketStack.pop();
        }
        return bracketStack.isEmpty();
    }

    private boolean isLeftBracket(char bracket) {
        return bracket == '[' || bracket == '(' || bracket == '{';
    }

    private boolean isParenthess(char left, char right) {
        if (left == '[') {
            return right == ']';
        }
        if (left == ']') {
            return right == '[';
        }
        if (left == '(') {
            return right == ')';
        }
        if (left == ')') {
            return right == '(';
        }
        if (left == '{') {
            return right == '}';
        }
        if (left == '}') {
            return right == '{';
        }
        return false;
    }
}
