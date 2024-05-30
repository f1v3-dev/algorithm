import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] dp = new int[100_001];
    static final int MOD = 9901;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2 * N 배열에 사자를 배치 -> 가로 세로 붙어있지 않게
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = ((dp[i - 1] * 2) + dp[i - 2]) % MOD;
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);

    }
}