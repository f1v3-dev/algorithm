import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);

            while (!stack.isEmpty() && stack.peek() < ch && k-- > 0) {
                stack.pop();
            }

            stack.push(ch);
        }

        while (k-- > 0) {
            stack.pop();
        }

        for (Character c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}