import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        for (int i = 3; i < 11; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n - 1]).append("\n");
        }

        System.out.println(sb);
    }
}