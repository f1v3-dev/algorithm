import java.util.*;

class Solution {
    public int solution(String s) {

        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            String current = s.substring(i) + s.substring(0, i);

            for (int j = 0; j < current.length(); j++) {
                char ch = current.charAt(j);

                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}
