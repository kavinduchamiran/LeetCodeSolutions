package Easy.ValidParentheses;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
        System.out.println(s.isValid("()[]{}"));
        System.out.println(s.isValid("(]"));
        System.out.println(s.isValid("]"));
    }

    public boolean isValid(String s) {

//        if ("]".equals(s) || "}".equals(s) || ")".equals(s)) {
//            return false;
//        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty() && (c == ']' && stack.peek() == '[' || c == '}' && stack.peek() == '{' || c == ')' && stack.peek() == '(')) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
