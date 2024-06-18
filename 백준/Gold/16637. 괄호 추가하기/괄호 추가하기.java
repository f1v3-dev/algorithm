import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int result = Integer.MIN_VALUE;
    static int n;
    static List<Integer> numbers = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                numbers.add(input.charAt(i) - '0');
            } else {
                operators.add(input.charAt(i));
            }
        }

        solve(0, numbers.get(0));
        System.out.println(result);
    }

    private static void solve(int index, int total) {

        if (index == operators.size()) {
            result = Math.max(result, total);
            return;
        }

        // 괄호를 사용하지 않는 경우
        int sum = calculate(total, numbers.get(index + 1), operators.get(index));
        solve(index + 1, sum);


        // 괄호를 사용하는 경우
        if (index + 1 < operators.size()) {
            int next = calculate(numbers.get(index + 1), numbers.get(index + 2), operators.get(index + 1));
            int nextTotal = calculate(total, next, operators.get(index));
            solve(index + 2, nextTotal);
        }

    }

    public static int calculate(int a, int b, char operator) {
        if (operator == '+') {
            return a + b;
        } else if (operator == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }
}