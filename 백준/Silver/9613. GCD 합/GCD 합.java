import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int gcd(int x, int y) {

        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            long result = 0;

            for (int k = 0; k < n - 1; k++) {
                for (int l = k + 1; l < n; l++) {
                    result += gcd(arr[k], arr[l]);
                }
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}