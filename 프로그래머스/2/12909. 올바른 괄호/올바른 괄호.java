import java.util.Stack;

class Solution {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>(); // ✅ 스택 선언

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 여는 괄호
            if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호
            else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        // ✅ 모든 문자를 검사한 후
        return stack.isEmpty();
    }
}
