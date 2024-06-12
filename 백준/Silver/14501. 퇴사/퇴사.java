import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Work {
    int time;
    int pay;

    public Work(int time, int pay) {
        this.time = time;
        this.pay = pay;
    }
}

public class Main {

    static int n;
    static Map<Integer, Work> works = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            int pay = Integer.parseInt(input[1]);
            works.put(i, new Work(time, pay));
        }


        solve();
    }

    private static void solve() {
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            Work work = works.get(i);
            int time = work.time;
            int pay = work.pay;

            max = Math.max(max, dp[i]);

            if (i + time <= n) {
                dp[i + time] = Math.max(dp[i + time], max + pay);
            }
        }

        max = Math.max(max, dp[n]);

        System.out.println(max);
    }
}