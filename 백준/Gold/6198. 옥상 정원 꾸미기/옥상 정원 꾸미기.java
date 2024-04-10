import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Long> stack = new Stack<>();

        long result = 0;

        for (int i = 0; i < N; i++) {

            long height = Long.parseLong(br.readLine());

            while (!stack.isEmpty() && stack.peek() <= height) {
                stack.pop();
            }

            result += stack.size();
            stack.push(height);
        }

        System.out.println(result);
    }
}