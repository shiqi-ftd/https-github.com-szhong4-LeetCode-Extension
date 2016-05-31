public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int counter = 0;
        Stack<Character> stk = new Stack();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stk.push('(');
            } else if (c == ')') {
                if (stk.empty()) {
                    continue;
                } else {
                    stk.pop();
                    counter += 2;
                }
            }
        }
        return counter;
    }
}