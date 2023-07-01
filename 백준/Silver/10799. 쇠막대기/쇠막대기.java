import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    count += stack.size();
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}