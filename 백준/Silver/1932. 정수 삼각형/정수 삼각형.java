import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            for (int j = 0; j < input.length; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {

            // left
            dp[i][0] = dp[i - 1][0] + arr[i][0];

            // mid (중간 값 계산)
            for (int j = 1; j < i; j++) {
                int max = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] = max + arr[i][j];
            }


            // right
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
        }

        // 마지막 배열에서 최대값 빼오기
        int max = Arrays.stream(dp[n - 1])
                .max()
                .orElse(0);

        System.out.println(max);
    }
}