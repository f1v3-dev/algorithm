import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());

            sb = new StringBuilder();
            solve(1, "1");
            System.out.println(sb);
        }
    }

    private static void solve(int current, String exp) {

        if (n == current) {
            if (isZero(exp)) {
                sb.append(exp).append("\n");
            }

            return;
        }

        // 숫자 사이에는 +, -, ' '(공백: 숫자를 이어 붙이는 것)이 들어갈 수 있음
        // ASCII 순서 -> 공백, +, - 순서대로 탐색
        int next = current + 1;
        solve(next, exp + " " + next);
        solve(next, exp + "+" + next);
        solve(next, exp + "-" + next);
    }

    private static boolean isZero(String exp) {
        exp = exp.replace(" ", "");

        // +, - 연산자를 기준으로 숫자를 나누기
        StringTokenizer st = new StringTokenizer(exp, "+|-", true);

        int total = Integer.parseInt(st.nextToken());
        while (st.hasMoreElements()) {

            String operator = st.nextToken();
            if ("+".equals(operator)) {
                total += Integer.parseInt(st.nextToken());
            } else {
                total -= Integer.parseInt(st.nextToken());
            }
        }

        return total == 0;
    }
}