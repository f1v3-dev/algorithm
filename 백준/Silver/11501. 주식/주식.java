import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];

            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[j] = Long.parseLong(input[j]);
            }

            sb.append(solve(arr)).append("\n");
        }

        System.out.println(sb);
    }

    private static long solve(long[] arr) {
        long profit = 0;
        long max = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                max = arr[i];
            } else {
                profit += max - arr[i];
            }
        }

        return profit;
    }
}