import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] candidates;
    static int b;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        candidates = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            candidates[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        b = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        solve();
    }

    private static void solve() {
        // 감독관 1명이 감시할 수 있는 수 : b
        // 부감독관 1명이 감시할 수 있는 수 : c
        // 각 시험장마다 총감독관 : 1명
        // 부감독관 : 여러명 가능
        long answer = 0;

        for (int i = 0; i < n; i++) {

            // 1. 총 감독관이 감시할 수 있는 수
            int remaining = candidates[i] - b;
            answer++;

            // 2. 부 감독관이 필요한 경우
            if (remaining > 0) {
                answer = answer + (remaining / c);
                int remain = remaining % c;
                if (remain > 0) {
                    answer++;
                }
            }

        }

        System.out.println(answer);

    }
}