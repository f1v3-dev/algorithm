import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        while (N-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (num > start) {
                for (int i = start + 1; i <= num; i++){
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = num;
            }

            if (stack.peek() != num) {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.println(sb);
    }
}