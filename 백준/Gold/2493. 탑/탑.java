import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");

        Stack<int[]> stack = new Stack<int[]>();

        for (int i = 0; i < num; i++) {
            int val = Integer.parseInt(input[i]);
            while (!stack.isEmpty()) {
                if (stack.peek()[0] > val) {
                    sb.append(stack.peek()[1]).append(" ");
                    break;
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
            }
            stack.push(new int[]{val, i + 1});
        }

        System.out.println(sb);
    }
}