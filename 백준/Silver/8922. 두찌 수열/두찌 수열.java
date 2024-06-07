import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            solve();
        }

        System.out.println(sb);
        br.close();
    }

    private static void solve() throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] input = br.readLine().split(" ");
        for (int j = 0; j < n; j++) {
            arr[j] = Integer.parseInt(input[j]);
        }

        // 1000번의 루프를 돌려 모두 0이 나오는지 확인?
        for (int j = 0; j < 1000; j++) {

            int first = arr[0];

            for (int k = 0; k < n - 1; k++) {
                arr[k] = Math.abs(arr[k] - arr[k + 1]);
            }

            arr[n - 1] = Math.abs(arr[n - 1] - first);

            // arr의 값이 모두 0이면 break
            boolean isZero = true;
            for (int k = 0; k < n; k++) {
                if (arr[k] != 0) {
                    isZero = false;
                    break;
                }
            }

            if (isZero) {
                sb.append("ZERO").append("\n");
                return;
            }
        }
        sb.append("LOOP").append("\n");
    }
}