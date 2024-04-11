import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[size];

        for (int i = size - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}