import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int VALUE = 10_007;

    public static int[][] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        // nCk = (n-1Ck-1 + n-1Ck)

        arr = new int[n + 1][k + 1];

        System.out.println(recursive(n, k));
    }

    public static int recursive(int n, int k) {

        if (arr[n][k] > 0) {
            return arr[n][k];
        }

        if (n == k || k == 0) {
            return arr[n][k] = 1;
        }

        return arr[n][k] = (recursive(n - 1, k - 1) + recursive(n - 1, k)) % VALUE;
    }
}