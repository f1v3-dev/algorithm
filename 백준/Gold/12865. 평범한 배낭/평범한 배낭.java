import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            for (int w = k; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }
        
        System.out.println(dp[k]);
    }
}