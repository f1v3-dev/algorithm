import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    private static int solve() {

        // 가장 긴 증가하는 부분 수열
        int[] dp = new int[arr.length];
        dp[0] = 1;

        int maxSequence = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;

            // i 이전의 값들을 하나씩 꺼내서 비교
            for (int j = 0; j < i; j++) {

                // 1. 수열이 증가하는가?
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }

            maxSequence = Math.max(maxSequence, dp[i]);
        }

        return maxSequence;
    }
}