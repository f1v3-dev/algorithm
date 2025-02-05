import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());

        for (int i = 1; i <= p; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            fibo(n, m);
        }

        System.out.println(sb);
    }

    private static void fibo(int n, int m) {

        int a = 1;
        int b = 1;
        int count = 0;

        do {
            int next = (a + b) % m;

            a = b;
            b = next;
            count++;

        } while (a != 1 || b != 1);

        sb.append(n).append(" ").append(count).append("\n");
    }
}