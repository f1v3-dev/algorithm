import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    static Map<Character, Integer> priority;

    static {
        priority = new HashMap<>();

        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);
        priority.put(')', 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            switch (cur) {
                case '+', '-', '*', '/':
                    while (!stack.isEmpty() && priority.get(stack.peek()) >= priority.get(cur)) {
                        sb.append(stack.pop());
                    }
                    stack.push(cur);
                    break;
                case '(':
                    stack.push(cur);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // '(' 제거
                    break;
                default:
                    sb.append(cur);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }


}