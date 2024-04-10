import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {

            Stack<String> left = new Stack<>();
            Stack<String> right = new Stack<>();

            String[] input = br.readLine().split("");

            for (String str : input) {

                switch (str) {
                    case "<":
                        if (!left.isEmpty()) {
                            String pop = left.pop();
                            right.push(pop);
                        }
                        break;

                    case ">":
                        if (!right.isEmpty()) {
                            String pop = right.pop();
                            left.push(pop);
                        }
                        break;

                    case "-":
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;

                    default:
                        left.push(str);
                }
            }

            while (!left.isEmpty()) {
                right.push(left.pop());
            }

            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}