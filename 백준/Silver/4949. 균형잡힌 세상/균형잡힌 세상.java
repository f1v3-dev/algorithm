import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String input;
        while (!(input = br.readLine()).equals(".")) {

            boolean isDone = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isDone = false;
                        break;
                    }
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isDone = false;
                        break;
                    }
                }
            }

            if (stack.isEmpty() && isDone) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }

            stack.clear();
        }

        System.out.print(sb);
    }
}