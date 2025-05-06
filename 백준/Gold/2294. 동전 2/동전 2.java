import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] coin = new int[n + 1];
        int[] dp = new int[k + 1];

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;

        Arrays.fill(dp, 1, k + 1, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                if (dp[j - coin[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
                }
            }
        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
    }
}