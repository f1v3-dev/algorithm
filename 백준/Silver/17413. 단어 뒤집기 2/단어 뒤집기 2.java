import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        boolean tagCheck = false;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '<') {
                // 먼저 스택에 쌓인 문자들을 뒤집어서 StringBuilder에 추가
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                tagCheck = true;
                sb.append(s.charAt(i));
            }

            else if (s.charAt(i) == '>') {
                tagCheck = false;
                sb.append(s.charAt(i));
            }

            else if (s.charAt(i) == ' ') {
                // 공백일 때도 스택에 쌓인 문자들을 뒤집어서 StringBuilder에 추가
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(s.charAt(i));
            }

            else if (tagCheck) {
                sb.append(s.charAt(i));
            }

            else {
                stack.push(s.charAt(i));
            }

            if (i == (s.length() - 1)) {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }
        }

        System.out.println(sb);
    }
}
